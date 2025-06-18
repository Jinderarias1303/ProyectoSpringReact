package com.atunes.proyecto.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.atunes.proyecto.Entity.Producto_lote;
import com.atunes.proyecto.Service.ProductoLoteService;

@RestController
@RequestMapping("/api/producto-lotes")
public class ProductoLoteController {

    @Autowired
    private ProductoLoteService productoLoteService;

    @GetMapping
    public ResponseEntity<List<Producto_lote>> getAllProductoLotes() {
        List<Producto_lote> lista = productoLoteService.listarTodos();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto_lote> getProductoLoteById(@PathVariable Long id) {
        Optional<Producto_lote> productoLote = productoLoteService.buscarPorId(id);
        return productoLote.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                           .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<Producto_lote> crearProductoLote(@RequestBody Producto_lote productoLote) {
        try {
            Producto_lote nuevo = productoLoteService.guardar(productoLote);
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto_lote> actualizarProductoLote(@PathVariable Long id, @RequestBody Producto_lote productoLote) {
        if (id == null || !id.equals(productoLote.getId())) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
        try {
            Producto_lote actualizado = productoLoteService.guardar(productoLote);
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProductoLote(@PathVariable Long id) {
        try {
            productoLoteService.eliminarPorId(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
