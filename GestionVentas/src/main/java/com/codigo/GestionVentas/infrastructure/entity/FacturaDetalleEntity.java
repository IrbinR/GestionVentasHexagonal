package com.codigo.GestionVentas.infrastructure.entity;


import com.codigo.GestionVentas.domain.model.FacturaDetalle;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "facturadetalle")
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDetalleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detalle_id;
    private Integer cantidad;
    private Integer precio_unitario;
    private Integer subtotal;
    @ManyToOne
    @JoinColumn(name = "factura_id")
    private FacturaCabeceraEntity facturaCabeceraEntity;
    @ManyToOne
    @JoinColumn(name = "producto_id")
    private ProductosEntity productosEntity;

    public static FacturaDetalleEntity modelEntity(FacturaDetalle facturaDetalle) {
        FacturaDetalleEntity entity = new FacturaDetalleEntity(
                facturaDetalle.getDetalle_id(),
                facturaDetalle.getCantidad(),
                facturaDetalle.getPrecio_unitario(),
                facturaDetalle.getSubtotal(),
                FacturaCabeceraEntity.modelEntity(facturaDetalle.getFacturaCabecera()),
                ProductosEntity.modelEntity(facturaDetalle.getProductos())
        );
        return entity;
    }

    public FacturaDetalle entityModel() {
        FacturaDetalle model = new FacturaDetalle();
        model.setDetalle_id(detalle_id);
        model.setCantidad(cantidad);
        model.setPrecio_unitario(precio_unitario);
        model.setSubtotal(subtotal);
        model.setFacturaCabecera(facturaCabeceraEntity.entityModel());
        model.setProductos(productosEntity.entityModel());
        return model;
    }
}
