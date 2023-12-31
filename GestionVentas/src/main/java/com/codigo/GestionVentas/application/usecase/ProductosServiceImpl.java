package com.codigo.GestionVentas.application.usecase;

import com.codigo.GestionVentas.domain.model.Productos;
import com.codigo.GestionVentas.domain.ports.input.ProductosInput;
import com.codigo.GestionVentas.domain.ports.output.ProductosOutput;

import java.util.List;
import java.util.Optional;

public class ProductosServiceImpl implements ProductosInput {
    private final ProductosOutput productosOutput;

    public ProductosServiceImpl(ProductosOutput productosOutput) {
        this.productosOutput = productosOutput;
    }

    @Override
    public Optional<Productos> create(Productos productos) {
        return productosOutput.create(productos);
    }

    @Override
    public List<Productos> read() {
        return productosOutput.read();
    }

    @Override
    public Optional<Productos> update(Long id, Productos productos) {
        return productosOutput.update(id, productos);
    }

    @Override
    public Optional<Productos> delete(Long id) {
        return productosOutput.delete(id);
    }

    @Override
    public Optional<Productos> search(Long id) {
        return productosOutput.search(id);
    }
}
