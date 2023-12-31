package com.codigo.GestionVentas.infrastructure.controller;

import com.codigo.GestionVentas.application.service.FacturaCabeceraService;
import com.codigo.GestionVentas.domain.model.FacturaCabecera;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/facturacabecera")
public class FacturaCabeceraController {
    private final FacturaCabeceraService facturaCabeceraService;

    public FacturaCabeceraController(FacturaCabeceraService facturaCabeceraService) {
        this.facturaCabeceraService = facturaCabeceraService;
    }
    @PostMapping()
    public ResponseEntity<Optional<FacturaCabecera>> crearFacturaCabecera(@RequestBody FacturaCabecera facturaCabecera) {
        return new ResponseEntity<>(facturaCabeceraService.create(facturaCabecera), HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<List<FacturaCabecera>> listarFacturaCabecera() {
        return new ResponseEntity<>(facturaCabeceraService.read(), HttpStatus.OK);
    }
    @PutMapping("{id}")
    public ResponseEntity<Optional<FacturaCabecera>> actualizarFacturaCabecera(@PathVariable Long id, @RequestBody FacturaCabecera facturaCabecera) {
        Optional<FacturaCabecera> model = facturaCabeceraService.update(id, facturaCabecera);
        if (model.isPresent()) {
            return new ResponseEntity<>(model, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<FacturaCabecera>> eliminarFacturaCabecera(@PathVariable Long id) {
        Optional<FacturaCabecera> model = facturaCabeceraService.delete(id);
        if (model.isPresent()) {
            return new ResponseEntity<>(model, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping("{id}")
    public ResponseEntity<Optional<FacturaCabecera>> buscarFacturaCabecera(@PathVariable Long id) {
        return new ResponseEntity<>(facturaCabeceraService.search(id), HttpStatus.OK);
    }
}
