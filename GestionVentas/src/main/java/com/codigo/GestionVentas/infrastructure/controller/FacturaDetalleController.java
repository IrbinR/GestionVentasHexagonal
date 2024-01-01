package com.codigo.GestionVentas.infrastructure.controller;

import com.codigo.GestionVentas.application.service.FacturaDetalleService;
import com.codigo.GestionVentas.domain.model.FacturaDetalle;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/facturadetalle")
public class FacturaDetalleController {
    private final FacturaDetalleService facturaDetalleService;

    public FacturaDetalleController(FacturaDetalleService facturaDetalleService) {
        this.facturaDetalleService = facturaDetalleService;
    }
    @PostMapping()
    public ResponseEntity<Optional<FacturaDetalle>> crearFacturaDetalle(@RequestBody FacturaDetalle facturaDetalle) {
        return new ResponseEntity<>(facturaDetalleService.create(facturaDetalle), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<FacturaDetalle>> listarFacturaDetalles() {
        return new ResponseEntity<>(facturaDetalleService.read(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Optional<FacturaDetalle>> actualizarFacturaDetalle(@PathVariable Long id, @RequestBody FacturaDetalle facturaDetalle) {
        Optional<FacturaDetalle> model = facturaDetalleService.update(id, facturaDetalle);
        if (model.isPresent()) {
            return new ResponseEntity<>(model, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<FacturaDetalle>> eliminarFacturaDetalle(@PathVariable Long id) {
        Optional<FacturaDetalle> model = facturaDetalleService.delete(id);
        if (model.isPresent()) {
            return new ResponseEntity<>(model, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<FacturaDetalle>> buscarFacturaDetalle(@PathVariable Long id) {
        Optional<FacturaDetalle> model = facturaDetalleService.search(id);
        if (model.isPresent()) {
            return new ResponseEntity<>(model, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/mostrarProductos/{id}")
    public ResponseEntity<List<FacturaDetalle>> mostrarProductos(@PathVariable Long id) {
        return new ResponseEntity<>(facturaDetalleService.mostrarProductos(id), HttpStatus.OK);
    }
}
