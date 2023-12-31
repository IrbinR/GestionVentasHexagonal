package com.codigo.GestionVentas.infrastructure.entity;

import com.codigo.GestionVentas.domain.model.Productos;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "productos")
@AllArgsConstructor
@NoArgsConstructor
public class ProductosEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long producto_id;
    private String nombre;
    private String descripcion;
    private Integer precio;
    private Integer stock;

    public static ProductosEntity modelEntity(Productos productos) {
        ProductosEntity entity = new ProductosEntity(
                productos.getProducto_id(),
                productos.getNombre(),
                productos.getDescripcion(),
                productos.getPrecio(),
                productos.getStock()
        );
        return entity;
    }

    public Productos entityModel() {
        Productos model = new Productos();
        model.setProducto_id(producto_id);
        model.setNombre(nombre);
        model.setDescripcion(descripcion);
        model.setPrecio(precio);
        model.setStock(stock);
        return model;
    }
}
