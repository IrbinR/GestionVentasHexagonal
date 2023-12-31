package com.codigo.GestionVentas.infrastructure.repository;

import com.codigo.GestionVentas.domain.model.Productos;
import com.codigo.GestionVentas.domain.ports.output.ProductosOutput;
import com.codigo.GestionVentas.infrastructure.entity.ProductosEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Component
public class ProductosAdapter implements ProductosOutput {
    private final ProductosRepository productosRepository;

    public ProductosAdapter(ProductosRepository productosRepository) {
        this.productosRepository = productosRepository;
    }

    @Override
    public Optional<Productos> create(Productos productos) {
        ProductosEntity entity = ProductosEntity.modelEntity(productos);
        return Optional.of(productosRepository.save(entity).entityModel());
    }

    @Override
    public List<Productos> read() {
        List<Productos> productos = new ArrayList<>();
        productosRepository.findAll().forEach(n -> productos.add(n.entityModel()));
        return productos;
    }

    @Override
    public Optional<Productos> update(Long id, Productos productos) {
        if (productosRepository.existsById(id)) {
            productosRepository.save(ProductosEntity.modelEntity(productos));
            return Optional.of(productos);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Productos> delete(Long id) {
        if (productosRepository.existsById(id)) {
            Optional<Productos> productos = search(id);
            productosRepository.deleteById(id);
            return productos;
        }
        return Optional.empty();
    }

    @Override
    public Optional<Productos> search(Long id) {
        return productosRepository.findById(id).map(ProductosEntity::entityModel);
    }
}
