package com.codigo.GestionVentas.domain.ports.input;



import com.codigo.GestionVentas.domain.model.Productos;

import java.util.List;
import java.util.Optional;

public interface ProductosInput {
    public Optional<Productos> create(Productos productos);
    public List<Productos> read();
    public Optional<Productos> update(Long id, Productos productos);
    public Optional<Productos> delete(Long id);
    public Optional<Productos> search(Long id);
}
