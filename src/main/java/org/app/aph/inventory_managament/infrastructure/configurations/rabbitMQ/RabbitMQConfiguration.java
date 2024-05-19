package org.app.aph.inventory_managament.infrastructure.configurations.rabbitMQ;

import org.app.aph.inventory_managament.infrastructure.repositories.IRabbitMQConfigurationRepository;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitMQConfiguration implements IRabbitMQConfigurationRepository {

    private final ConnectionFactory connectionFactory;

    public RabbitMQConfiguration(ConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    public Queue queue(String name) {
        Queue queue = new Queue(name, true);
        new RabbitAdmin(connectionFactory).declareQueue(queue);
        return queue;
    }

    @Bean
    public RabbitAdmin rabbitAdmin(){
        return new RabbitAdmin(connectionFactory);
    }

    @Override
    public Exchange exchange(String name, String type) {
        switch (type) {
            case ExchangeTypes.TOPIC -> {
                return new TopicExchange(name, true, false);
            }
            case ExchangeTypes.DIRECT -> {
                return new DirectExchange(name, true, false);
            }
            case ExchangeTypes.FANOUT -> {
                return new FanoutExchange(name, true, false);
            }
            case ExchangeTypes.HEADERS -> {
                return new HeadersExchange(name, true, false);
            }
            default -> {
                return new CustomExchange(name, type, true, false);
            }
        }
    }

    @Override
    public Binding binding(String queue, String exchange, String type, String routingKey) {
        return BindingBuilder.bind(queue(queue)).to(exchange(exchange, type)).with(routingKey).noargs();
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(new Jackson2JsonMessageConverter());
        return rabbitTemplate;
    }

}