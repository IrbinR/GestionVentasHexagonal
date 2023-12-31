package com.codigo.GestionVentas.infrastructure.repository;

import com.codigo.GestionVentas.infrastructure.entity.ProductosEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository<ProductosEntity, Long> {
}
