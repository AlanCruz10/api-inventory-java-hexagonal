package org.app.aph.inventory_managament.infrastructure.persistance.repositories;

import org.app.aph.inventory_managament.infrastructure.persistance.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IProductRepository extends JpaRepository<ProductEntity, Long> {

    Optional<ProductEntity> findByUuid(String uuid);

}