package com.codigo.GestionVentas.infrastructure.repository;

import com.codigo.GestionVentas.infrastructure.entity.FacturaDetalleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;
public interface FacturaDetalleRepository extends JpaRepository<FacturaDetalleEntity, Long> {
    @Query(value = "select f from FacturaDetalleEntity f where f.facturaCabeceraEntity.factura_id = :id")
    public List<FacturaDetalleEntity> mostrarProductos(@Param("id") Long id);

}
