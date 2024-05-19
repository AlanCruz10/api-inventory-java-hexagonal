package org.app.aph.inventory_managament.infrastructure.enums;

import lombok.Getter;

@Getter
public enum RabbitMQQueueEnum {

    QUEUE_TRACKING("traking-queue-v1"),
    QUEUE_TRACKING_RESPONSE("tracking-queue-response-v1");


    private final String queue;

    RabbitMQQueueEnum(String code) {
        this.queue = code;
    }

}