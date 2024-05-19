package org.app.aph.inventory_managament.infrastructure.rest.rabbitMQ.consumers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import org.app.aph.inventory_managament.application.dtos.responses.BaseResponse;
import org.app.aph.inventory_managament.application.use_cases.InventoryUseCaseImpl;
import org.app.aph.inventory_managament.domain.entities.OrderProduct;
import org.app.aph.inventory_managament.infrastructure.configurations.rabbitMQ.RabbitMQConfiguration;
import org.app.aph.inventory_managament.infrastructure.enums.RabbitMQQueueEnum;
import org.app.aph.inventory_managament.infrastructure.mappers.RabbitMQMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RabbitMQConsumer {

    private final RabbitMQConfiguration rabbitMQConfiguration;

    private final InventoryUseCaseImpl inventoryUseCase;

    public RabbitMQConsumer(RabbitMQConfiguration rabbitMQConfiguration, InventoryUseCaseImpl inventoryUseCase) {
        this.rabbitMQConfiguration = rabbitMQConfiguration;
        this.inventoryUseCase = inventoryUseCase;
    }

    @RabbitListener(queues = {"traking-queue-v1"})
    public void eventReduceStock(String list) throws JsonProcessingException {
//        List<OrderProduct> listOrderProduct = RabbitMQMapper.deserialize(list, List.class).stream().map(e -> {
//            try {
//                String serialize = RabbitMQMapper.serialize(e);
//                return RabbitMQMapper.deserialize(serialize, OrderProduct.class);
//            } catch (JsonProcessingException ex) {
//                throw new RuntimeException(ex);
//            }
//        }).toList();
        List<OrderProduct> deserialize = RabbitMQMapper.deserialize(list, new TypeReference<List<OrderProduct>>() {
        });
        BaseResponse baseResponse = inventoryUseCase.reduceStock(deserialize);
        rabbitMQConfiguration.rabbitTemplate().convertAndSend(rabbitMQConfiguration.queue(RabbitMQQueueEnum.QUEUE_TRACKING_RESPONSE.getQueue()).getActualName(), baseResponse);
    }

}