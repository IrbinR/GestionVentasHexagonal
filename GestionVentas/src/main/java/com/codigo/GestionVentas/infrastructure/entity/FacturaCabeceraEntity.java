package com.codigo.GestionVentas.infrastructure.entity;

import com.codigo.GestionVentas.domain.model.FacturaCabecera;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "facturacabecera")
@AllArgsConstructor
@NoArgsConstructor
public class FacturaCabeceraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long factura_id;
    private String cliente_nombre;
    private String cliente_num_documento;
    private Date fecha_emision;
    private Integer total;

    public static FacturaCabeceraEntity modelEntity(FacturaCabecera facturaCabecera) {
        FacturaCabeceraEntity entity = new FacturaCabeceraEntity(
                facturaCabecera.getFactura_id(),
                facturaCabecera.getCliente_nombre(),
                facturaCabecera.getCliente_num_documento(),
                facturaCabecera.getFecha_emision(),
                facturaCabecera.getTotal()
        );
        return entity;
    }

    public FacturaCabecera entityModel() {
        FacturaCabecera model = new FacturaCabecera();
        model.setFactura_id(factura_id);
        model.setCliente_nombre(cliente_nombre);
        model.setCliente_num_documento(cliente_num_documento);
        model.setFecha_emision(fecha_emision);
        model.setTotal(total);
        return model;
    }
}
