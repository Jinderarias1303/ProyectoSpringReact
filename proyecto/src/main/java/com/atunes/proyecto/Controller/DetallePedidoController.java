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

import com.atunes.proyecto.Entity.DetallePedido;
import com.atunes.proyecto.Service.DetallePedidoService;

@RestController
@RequestMapping("/api/detalles-pedido")
public class DetallePedidoController {

    @Autowired
    private DetallePedidoService detallePedidoService;

    @GetMapping
    public ResponseEntity<List<DetallePedido>> getAllDetallesPedido() {
        List<DetallePedido> detalles = detallePedidoService.listarTodos();
        return new ResponseEntity<>(detalles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetallePedido> getDetallePedidoById(@PathVariable Long id) {
        Optional<DetallePedido> detalle = detallePedidoService.buscarPorId(id);
        return detalle.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                      .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<DetallePedido> crearDetallePedido(@RequestBody DetallePedido detallePedido) {
        try {
            DetallePedido nuevo = detallePedidoService.guardar(detallePedido);
            return new ResponseEntity<>(nuevo, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetallePedido> guardar(@PathVariable Long id, @RequestBody DetallePedido detallePedido) {
        if (id == null || !id.equals(detallePedido.getId())) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        try {
            DetallePedido actualizado = detallePedidoService.guardar(detallePedido);
            return new ResponseEntity<>(actualizado, HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPorId(@PathVariable Long id) {
        try {
            detallePedidoService.eliminarPorId(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
