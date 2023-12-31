package com.codigo.GestionVentas.infrastructure.repository;

import com.codigo.GestionVentas.domain.model.FacturaCabecera;
import com.codigo.GestionVentas.domain.ports.output.FacturaCabeceraOutput;
import com.codigo.GestionVentas.infrastructure.entity.FacturaCabeceraEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class FacturaCabeceraAdapter implements FacturaCabeceraOutput {
    private final FacturaCabeceraRepository facturaCabeceraRepository;

    public FacturaCabeceraAdapter(FacturaCabeceraRepository facturaCabeceraRepository) {
        this.facturaCabeceraRepository = facturaCabeceraRepository;
    }

    @Override
    public Optional<FacturaCabecera> create(FacturaCabecera facturaCabecera) {
        FacturaCabeceraEntity facturaCabeceraEntity = FacturaCabeceraEntity.modelEntity(facturaCabecera);
        return Optional.of(facturaCabeceraRepository.save(facturaCabeceraEntity).entityModel());
    }

    @Override
    public List<FacturaCabecera> read() {
        List<FacturaCabecera> facturaCabeceras = new ArrayList<>();
        facturaCabeceraRepository.findAll().forEach(n -> facturaCabeceras.add(n.entityModel()));
        return facturaCabeceras;

    }

    @Override
    public Optional<FacturaCabecera> update(Long id, FacturaCabecera facturaCabecera) {
        if (facturaCabeceraRepository.existsById(id)) {
            facturaCabeceraRepository.save(FacturaCabeceraEntity.modelEntity(facturaCabecera));
            return  Optional.of(facturaCabecera);
        }
        return Optional.empty();
    }

    @Override
    public Optional<FacturaCabecera> delete(Long id) {
        if (facturaCabeceraRepository.existsById(id)) {
            Optional<FacturaCabecera> facturaCabecera = search(id);
            facturaCabeceraRepository.deleteById(id);
            return facturaCabecera;
        }
        return Optional.empty();
    }

    @Override
    public Optional<FacturaCabecera> search(Long id) {
        return facturaCabeceraRepository.findById(id).map(FacturaCabeceraEntity::entityModel);
    }
}
