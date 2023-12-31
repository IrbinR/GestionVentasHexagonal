package com.codigo.GestionVentas.application.service;

import com.codigo.GestionVentas.domain.model.Productos;
import com.codigo.GestionVentas.domain.ports.input.ProductosInput;

import java.util.List;
import java.util.Optional;

public class ProductosService implements ProductosInput {

    private final ProductosInput productosInput;

    public ProductosService(ProductosInput productosInput) {
        this.productosInput = productosInput;
    }

    @Override
    public Optional<Productos> create(Productos productos) {
        return productosInput.create(productos);
    }

    @Override
    public List<Productos> read() {
        return productosInput.read();
    }

    @Override
    public Optional<Productos> update(Long id, Productos productos) {
        return productosInput.update(id, productos);
    }

    @Override
    public Optional<Productos> delete(Long id) {
        return productosInput.delete(id);
    }

    @Override
    public Optional<Productos> search(Long id) {
        return productosInput.search(id);
    }
}
