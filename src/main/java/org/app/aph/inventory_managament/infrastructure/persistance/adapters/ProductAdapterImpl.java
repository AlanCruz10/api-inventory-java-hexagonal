package org.app.aph.inventory_managament.infrastructure.persistance.adapters;

import org.app.aph.inventory_managament.application.ports.inputs.IProductPortInput;
import org.app.aph.inventory_managament.domain.entities.Product;
import org.app.aph.inventory_managament.infrastructure.persistance.mappers.ProductMapper;
import org.app.aph.inventory_managament.infrastructure.persistance.repositories.IProductRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductAdapterImpl implements IProductPortInput {

    private final IProductRepository repository;

    private final ProductMapper mapper;

    public ProductAdapterImpl(IProductRepository repository, ProductMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Product> list() {
        return mapper.toDomain(repository.findAll());
    }

    @Override
    public Product save(Product product) {
        return mapper.toDomain(repository.save(mapper.toEntity(product)));
    }

    @Override
    public Product findByUuid(String uuid) {
        return mapper.toDomain(repository.findByUuid(uuid).orElseThrow(RuntimeException::new));
    }

    @Override
    public void delete(String uuid) {
        repository.delete(mapper.toEntity(findByUuid(uuid)));
    }

}