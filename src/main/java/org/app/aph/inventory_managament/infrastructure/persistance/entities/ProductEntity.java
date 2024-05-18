package org.app.aph.inventory_managament.infrastructure.persistance.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Getter
@Setter
@Table(name = "products")
public class ProductEntity {

    @Id
    @UuidGenerator
    @Column(nullable = false, unique = true)
    private String uuid;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Long stock;

}