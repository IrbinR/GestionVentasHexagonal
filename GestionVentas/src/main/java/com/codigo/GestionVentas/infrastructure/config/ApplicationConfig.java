package com.codigo.GestionVentas.infrastructure.config;

import com.codigo.GestionVentas.application.service.FacturaCabeceraService;
import com.codigo.GestionVentas.application.service.FacturaDetalleService;
import com.codigo.GestionVentas.application.service.ProductosService;
import com.codigo.GestionVentas.application.usecase.FacturaCabeceraServiceImpl;
import com.codigo.GestionVentas.application.usecase.FacturaDetalleServiceImpl;
import com.codigo.GestionVentas.application.usecase.ProductosServiceImpl;
import com.codigo.GestionVentas.domain.ports.output.FacturaCabeceraOutput;
import com.codigo.GestionVentas.domain.ports.output.FacturaDetalleOutput;
import com.codigo.GestionVentas.domain.ports.output.ProductosOutput;
import com.codigo.GestionVentas.infrastructure.repository.FacturaCabeceraAdapter;
import com.codigo.GestionVentas.infrastructure.repository.FacturaDetalleAdapter;
import com.codigo.GestionVentas.infrastructure.repository.ProductosAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
    @Bean
    public FacturaCabeceraService facturaCabeceraService(FacturaCabeceraOutput facturaCabeceraOutput) {
        return new FacturaCabeceraService(new FacturaCabeceraServiceImpl(facturaCabeceraOutput));
    }
    @Bean
    public FacturaCabeceraOutput facturaCabeceraOutput(FacturaCabeceraAdapter facturaCabeceraAdapter) {
        return facturaCabeceraAdapter;
    }
    @Bean
    public FacturaDetalleService facturaDetalleService(FacturaDetalleOutput facturaDetalleOutput) {
        return new FacturaDetalleService(new FacturaDetalleServiceImpl(facturaDetalleOutput));
    }
    @Bean
    public FacturaDetalleOutput facturaDetalleOutput(FacturaDetalleAdapter facturaDetalleAdapter) {
        return facturaDetalleAdapter;
    }

    @Bean
    public ProductosService productosService(ProductosOutput productosOutput) {
        return new ProductosService(new ProductosServiceImpl(productosOutput));
    }

    @Bean
    public ProductosOutput productosOutput(ProductosAdapter productosAdapter) {
        return productosAdapter;
    }
}
