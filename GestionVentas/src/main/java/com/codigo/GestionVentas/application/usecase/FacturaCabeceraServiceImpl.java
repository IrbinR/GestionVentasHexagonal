package com.codigo.GestionVentas.application.usecase;

import com.codigo.GestionVentas.domain.model.FacturaCabecera;
import com.codigo.GestionVentas.domain.ports.input.FacturaCabeceraInput;
import com.codigo.GestionVentas.domain.ports.output.FacturaCabeceraOutput;

import java.util.List;
import java.util.Optional;

public class FacturaCabeceraServiceImpl implements FacturaCabeceraInput {
    private final FacturaCabeceraOutput facturaCabeceraOutput;

    public FacturaCabeceraServiceImpl(FacturaCabeceraOutput facturaCabeceraOutput) {
        this.facturaCabeceraOutput = facturaCabeceraOutput;
    }

    @Override
    public Optional<FacturaCabecera> create(FacturaCabecera facturaCabecera) {
        return facturaCabeceraOutput.create(facturaCabecera);
    }

    @Override
    public List<FacturaCabecera> read() {
        return facturaCabeceraOutput.read();
    }

    @Override
    public Optional<FacturaCabecera> update(Long id, FacturaCabecera facturaCabecera) {
        return facturaCabeceraOutput.update(id, facturaCabecera);
    }

    @Override
    public Optional<FacturaCabecera> delete(Long id) {
        return facturaCabeceraOutput.delete(id);
    }

    @Override
    public Optional<FacturaCabecera> search(Long id) {
        return facturaCabeceraOutput.search(id);
    }
}
