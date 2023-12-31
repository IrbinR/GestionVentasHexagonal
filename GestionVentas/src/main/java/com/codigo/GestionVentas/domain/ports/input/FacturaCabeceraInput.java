package com.codigo.GestionVentas.domain.ports.input;

import com.codigo.GestionVentas.domain.model.FacturaCabecera;

import java.util.List;
import java.util.Optional;

public interface FacturaCabeceraInput {
    public Optional<FacturaCabecera> create(FacturaCabecera facturaCabecera);
    public List<FacturaCabecera> read();
    public Optional<FacturaCabecera> update(Long id,FacturaCabecera facturaCabecera);
    public Optional<FacturaCabecera> delete(Long id);
    public Optional<FacturaCabecera> search(Long id);
}
