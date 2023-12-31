package com.codigo.GestionVentas.infrastructure.repository;

import com.codigo.GestionVentas.infrastructure.entity.FacturaCabeceraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaCabeceraRepository extends JpaRepository<FacturaCabeceraEntity, Long> {
}
