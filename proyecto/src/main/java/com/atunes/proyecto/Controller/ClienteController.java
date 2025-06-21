package com.atunes.proyecto.Controller;

import com.atunes.proyecto.Entity.Cliente;
import com.atunes.proyecto.Service.ClienteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/cliente")
@CrossOrigin(origins = "*") // Esto permite acceso desde frontend React
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    // Listar todos los clientes
    @GetMapping
    public ResponseEntity<List<Cliente>> listarClientes() {
        List<Cliente> clientes = clienteService.listarTodosLosClientes();
        return ResponseEntity.ok(clientes);
    }

    // Buscar cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> obtenerClientePorId(@PathVariable Long id) {
        return clienteService.buscarClientePorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Crear un nuevo cliente
    @PostMapping
    public ResponseEntity<Cliente> crearCliente(@RequestBody Cliente cliente) {
        Cliente nuevoCliente = clienteService.guardarCliente(cliente);
        return ResponseEntity.ok(nuevoCliente);
    }

    // Actualizar cliente existente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> actualizarCliente(@PathVariable Long id, @RequestBody Cliente cliente) {
        if (!clienteService.existeCliente(id)) {
            return ResponseEntity.notFound().build();
        }
        cliente.setId(id);
        Cliente clienteActualizado = clienteService.guardarCliente(cliente);
        return ResponseEntity.ok(clienteActualizado);
    }

    // Eliminar cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCliente(@PathVariable Long id) {
        if (!clienteService.existeCliente(id)) {
            return ResponseEntity.notFound().build();
        }
        clienteService.eliminarCliente(id);
        return ResponseEntity.noContent().build();
    }
}
