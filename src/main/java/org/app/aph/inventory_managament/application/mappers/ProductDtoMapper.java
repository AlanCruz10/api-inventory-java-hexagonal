package org.app.aph.inventory_managament.application.mappers;

import org.app.aph.inventory_managament.application.dtos.requests.CreateProductRequest;
import org.app.aph.inventory_managament.application.dtos.responses.ProductResponse;
import org.app.aph.inventory_managament.domain.entities.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDtoMapper {

    public ProductDtoMapper() { }

    public Product toDomain(CreateProductRequest request) {
        Product product = new Product();
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setStock(request.getStock());
        return product;
    }

    public ProductResponse toDto(Product product) {
        return ProductResponse.builder()
                .uuid(product.getUuid())
                .price(product.getPrice())
                .stock(product.getStock())
                .name(product.getName()).build();
    }

    public List<ProductResponse> toListDto(List<Product> productList) {
        return productList.stream().map(this::toDto).toList();
    }

}