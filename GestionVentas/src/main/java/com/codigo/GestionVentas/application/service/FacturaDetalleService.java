package com.codigo.GestionVentas.application.service;

import com.codigo.GestionVentas.domain.model.FacturaDetalle;
import com.codigo.GestionVentas.domain.ports.input.FacturaDetalleInput;

import java.util.List;
import java.util.Optional;

public class FacturaDetalleService implements FacturaDetalleInput {

    private final FacturaDetalleInput facturaDetalleInput;

    public FacturaDetalleService(FacturaDetalleInput facturaDetalleInput) {
        this.facturaDetalleInput = facturaDetalleInput;
    }

    @Override
    public Optional<FacturaDetalle> create(FacturaDetalle facturaDetalle) {
        return facturaDetalleInput.create(facturaDetalle);
    }

    @Override
    public List<FacturaDetalle> read() {
        return facturaDetalleInput.read();
    }

    @Override
    public Optional<FacturaDetalle> update(Long id, FacturaDetalle facturaDetalle) {
        return facturaDetalleInput.update(id, facturaDetalle);
    }

    @Override
    public Optional<FacturaDetalle> delete(Long id) {
        return facturaDetalleInput.delete(id);
    }

    @Override
    public Optional<FacturaDetalle> search(Long id) {
        return facturaDetalleInput.search(id);
    }
}
