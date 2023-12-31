package com.codigo.GestionVentas.infrastructure.controller;

import ch.qos.logback.core.pattern.parser.OptionTokenizer;
import com.codigo.GestionVentas.application.service.ProductosService;
import com.codigo.GestionVentas.domain.model.Productos;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
public class ProductosController {
    private final ProductosService productosService;

    public ProductosController(ProductosService productosService) {
        this.productosService = productosService;
    }
    @PostMapping()
    public ResponseEntity<Optional<Productos>> crearProducto(@RequestBody Productos productos) {
        return new ResponseEntity<>(productosService.create(productos), HttpStatus.CREATED);
    }
    @GetMapping()
    public ResponseEntity<List<Productos>> listarProductos() {
        return new ResponseEntity<>(productosService.read(), HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Optional<Productos>> actualizarProducto(@PathVariable Long id, @RequestBody Productos productos) {
        Optional<Productos> model = productosService.update(id, productos);
        if (model.isPresent()) {
            return new ResponseEntity<>(model, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Optional<Productos>> eliminarProducto(@PathVariable Long id) {
        Optional<Productos> model = productosService.delete(id);
        if (model.isPresent()) {
            return new ResponseEntity<>(model, HttpStatus.ACCEPTED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Optional<Productos>> buscarProducto(@PathVariable Long id) {
        Optional<Productos> model = productosService.search(id);
        if (model.isPresent()) {
            return new ResponseEntity<>(model, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
