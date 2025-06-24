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

import com.atunes.proyecto.Entity.ProductoLote;
import com.atunes.proyecto.Service.ProductoLoteService;

@RestController
@RequestMapping("/api/productoLote")
public class ProductoLoteController {

    @Autowired
    private ProductoLoteService productoLoteService;

    @GetMapping
    public ResponseEntity<List<ProductoLote>> getAllProductoLotes() {
        List<ProductoLote> lista = productoLoteService.listarTodos();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoLote> getProductoLoteById(@PathVariable Long id) {
        Optional<ProductoLote> productoLote = productoLoteService.buscarPorId(id);
        return productoLote.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                           .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<ProductoLote> crearProductoLote(@RequestBody ProductoLote productoLote) {
        try {
            ProductoLote nuevo = productoLoteService.guardar(productoLote);
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoLote> actualizarProductoLote(@PathVariable Long id, @RequestBody ProductoLote productoLote) {
        if (id == null || !id.equals(productoLote.getId())) {
            return new ResponseEntity<>( HttpStatus.BAD_REQUEST);
        }
        try {
            ProductoLote actualizado = productoLoteService.guardar(productoLote);
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
