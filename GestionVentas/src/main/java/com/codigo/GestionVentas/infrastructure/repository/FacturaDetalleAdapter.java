package com.codigo.GestionVentas.infrastructure.repository;

import com.codigo.GestionVentas.domain.model.FacturaDetalle;
import com.codigo.GestionVentas.domain.ports.output.FacturaDetalleOutput;
import com.codigo.GestionVentas.infrastructure.entity.FacturaDetalleEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class FacturaDetalleAdapter implements FacturaDetalleOutput {
    private final FacturaDetalleRepository facturaDetalleRepository;

    public FacturaDetalleAdapter(FacturaDetalleRepository facturaDetalleRepository) {
        this.facturaDetalleRepository = facturaDetalleRepository;
    }

    @Override
    public Optional<FacturaDetalle> create(FacturaDetalle facturaDetalle) {
        FacturaDetalleEntity entity = FacturaDetalleEntity.modelEntity(facturaDetalle);
        return Optional.of(facturaDetalleRepository.save(entity).entityModel());
    }

    @Override
    public List<FacturaDetalle> read() {
        List<FacturaDetalle> facturaDetalles = new ArrayList<>();
        facturaDetalleRepository.findAll().forEach(n -> facturaDetalles.add(n.entityModel()));
        return facturaDetalles;
    }

    @Override
    public Optional<FacturaDetalle> update(Long id, FacturaDetalle facturaDetalle) {
        if (facturaDetalleRepository.existsById(id)) {
            facturaDetalleRepository.save(FacturaDetalleEntity.modelEntity(facturaDetalle));
            return Optional.of(facturaDetalle);
        }
        return Optional.empty();
    }

    @Override
    public Optional<FacturaDetalle> delete(Long id) {
        if (facturaDetalleRepository.existsById(id)) {
            Optional<FacturaDetalle> facturaDetalle = search(id);
            facturaDetalleRepository.deleteById(id);
            return facturaDetalle;
        }
        return Optional.empty();
    }

    @Override
    public Optional<FacturaDetalle> search(Long id) {
        return facturaDetalleRepository.findById(id).map(FacturaDetalleEntity::entityModel);
    }
}
