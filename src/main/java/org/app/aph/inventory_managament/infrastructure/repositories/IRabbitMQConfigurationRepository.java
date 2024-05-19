package org.app.aph.inventory_managament.infrastructure.repositories;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;

public interface IRabbitMQConfigurationRepository {

    Queue queue(String name);

    Exchange exchange(String name, String type);

    Binding binding(String queue, String exchange, String type, String routingKey);

}