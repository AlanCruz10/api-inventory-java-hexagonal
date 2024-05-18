package org.app.aph.inventory_managament.infrastructure.persistance.mappers;

import org.app.aph.inventory_managament.domain.entities.Product;
import org.app.aph.inventory_managament.infrastructure.persistance.entities.ProductEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductMapper {

    public ProductMapper() {}

    public Product toDomain(ProductEntity entity){
        Product product = new Product();
        product.setUuid(entity.getUuid());
        product.setName(entity.getName());
        product.setPrice(entity.getPrice());
        product.setStock(entity.getStock());
        return product;
    }

    public ProductEntity toEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setUuid(product.getUuid());
        productEntity.setName(product.getName());
        productEntity.setPrice(product.getPrice());
        productEntity.setStock(product.getStock());
        return productEntity;
    }

    public List<Product> toDomain(List<ProductEntity> entityList) {
        return entityList.stream().map(this::toDomain).collect(Collectors.toList());
    }

}