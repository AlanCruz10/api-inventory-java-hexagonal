package org.app.aph.inventory_managament.domain.entities;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {

    private String uuid;

    private String name;

    private Double price;

    private Long stock;

}