package com.codigo.GestionVentas.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FacturaDetalle {
    private Long detalle_id;
    private Integer cantidad;
    private Integer precio_unitario;
    private Integer subtotal;
    private FacturaCabecera facturaCabecera;
    private Productos productos;
}
