package com.codigo.GestionVentas.application.usecase;

import com.codigo.GestionVentas.domain.model.FacturaDetalle;
import com.codigo.GestionVentas.domain.ports.input.FacturaDetalleInput;
import com.codigo.GestionVentas.domain.ports.output.FacturaDetalleOutput;

import java.util.List;
import java.util.Optional;

public class FacturaDetalleServiceImpl implements FacturaDetalleInput {
    private final FacturaDetalleOutput facturaDetalleOutput;

    public FacturaDetalleServiceImpl(FacturaDetalleOutput facturaDetalleOutput) {
        this.facturaDetalleOutput = facturaDetalleOutput;
    }

    @Override
    public Optional<FacturaDetalle> create(FacturaDetalle facturaDetalle) {
        return facturaDetalleOutput.create(facturaDetalle);
    }

    @Override
    public List<FacturaDetalle> read() {
        return facturaDetalleOutput.read();
    }

    @Override
    public Optional<FacturaDetalle> update(Long id, FacturaDetalle facturaDetalle) {
        return facturaDetalleOutput.update(id, facturaDetalle);
    }

    @Override
    public Optional<FacturaDetalle> delete(Long id) {
        return facturaDetalleOutput.delete(id);
    }

    @Override
    public Optional<FacturaDetalle> search(Long id) {
        return facturaDetalleOutput.search(id);
    }

    @Override
    public List<FacturaDetalle> mostrarProductos(Long id) {
        return facturaDetalleOutput.mostrarProductos(id);
    }
}
