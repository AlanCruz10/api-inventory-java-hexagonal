package org.app.aph.inventory_managament.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderProduct {

    private String uuid;

    private Double price;

    private Long quantity;

    private String productId;

    private String orderId;

}