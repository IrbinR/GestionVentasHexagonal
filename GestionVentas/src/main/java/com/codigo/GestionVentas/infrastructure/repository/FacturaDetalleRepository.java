package com.codigo.GestionVentas.infrastructure.repository;

import com.codigo.GestionVentas.infrastructure.entity.FacturaDetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaDetalleRepository extends JpaRepository<FacturaDetalleEntity, Long> {
}
