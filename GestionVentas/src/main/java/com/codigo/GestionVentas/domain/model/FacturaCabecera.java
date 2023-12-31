package com.codigo.GestionVentas.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
@Getter
@Setter
public class FacturaCabecera {
    private Long factura_id;
    private String cliente_nombre;
    private String cliente_num_documento;
    private Date fecha_emision;
    private Integer total;
}
