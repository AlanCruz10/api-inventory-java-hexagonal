package org.app.aph.inventory_managament.application.ports.inputs;

import org.app.aph.inventory_managament.domain.entities.Product;

import java.util.List;

public interface IProductPortInput {

    List<Product> list();

    Product save(Product product);

    Product findByUuid(String uuid);

    void delete(String uuid);

}