package com.codigo.GestionVentas.application.service;


import com.codigo.GestionVentas.domain.model.FacturaCabecera;
import com.codigo.GestionVentas.domain.ports.input.FacturaCabeceraInput;

import java.util.List;
import java.util.Optional;

public class FacturaCabeceraService implements FacturaCabeceraInput {
    private final FacturaCabeceraInput facturaCabeceraInput;

    public FacturaCabeceraService(FacturaCabeceraInput facturaCabeceraInput) {
        this.facturaCabeceraInput = facturaCabeceraInput;
    }

    @Override
    public Optional<FacturaCabecera> create(FacturaCabecera facturaCabecera) {
        return facturaCabeceraInput.create(facturaCabecera);
    }

    @Override
    public List<FacturaCabecera> read() {
        return facturaCabeceraInput.read();
    }

    @Override
    public Optional<FacturaCabecera> update(Long id, FacturaCabecera facturaCabecera) {
        return facturaCabeceraInput.update(id, facturaCabecera);
    }

    @Override
    public Optional<FacturaCabecera> delete(Long id) {
        return facturaCabeceraInput.delete(id);
    }

    @Override
    public Optional<FacturaCabecera> search(Long id) {
        return facturaCabeceraInput.search(id);
    }
}
