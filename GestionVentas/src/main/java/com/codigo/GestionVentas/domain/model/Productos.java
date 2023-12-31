package com.codigo.GestionVentas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
public class Productos {
    private Long producto_id;
    private String nombre;
    private String descripcion;
    private Integer precio;
    private Integer stock;
}
