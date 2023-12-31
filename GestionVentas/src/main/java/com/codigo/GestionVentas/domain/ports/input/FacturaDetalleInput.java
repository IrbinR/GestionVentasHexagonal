package com.codigo.GestionVentas.domain.ports.input;

import com.codigo.GestionVentas.domain.model.FacturaDetalle;

import java.util.List;
import java.util.Optional;

public interface FacturaDetalleInput {
    public Optional<FacturaDetalle> create(FacturaDetalle facturaDetalle);
    public List<FacturaDetalle> read();
    public Optional<FacturaDetalle> update(Long id, FacturaDetalle facturaDetalle);
    public Optional<FacturaDetalle> delete(Long id);
    public Optional<FacturaDetalle> search(Long id);
}
