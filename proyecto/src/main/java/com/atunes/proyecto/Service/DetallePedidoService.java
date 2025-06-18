package com.atunes.proyecto.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atunes.proyecto.Entity.DetallePedido;
import com.atunes.proyecto.Repository.RepositoryDetallePedido;

import jakarta.transaction.Transactional;

@Service
public class DetallePedidoService {

    @Autowired
    private RepositoryDetallePedido repositoryDetallePedido;

    // Listar todos los detalles de pedido
    @Transactional
    public List<DetallePedido> listarTodos() {
        return repositoryDetallePedido.findAll();
    }

    // Buscar por ID
    @Transactional
    public Optional<DetallePedido> buscarPorId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        }
        return repositoryDetallePedido.findById(id);
    }

    // Guardar o actualizar un detalle de pedido
    @Transactional
    public DetallePedido guardar(DetallePedido detallePedido) {
        if (detallePedido == null) {
            throw new IllegalArgumentException("El detalle de pedido no puede ser nulo.");
        }
        return repositoryDetallePedido.save(detallePedido);
    }

    // Eliminar por ID
    @Transactional
    public void eliminarPorId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        }
        if (!repositoryDetallePedido.existsById(id)) {
            throw new IllegalArgumentException("No existe un detalle de pedido con ID: " + id);
        }
        repositoryDetallePedido.deleteById(id);
    }
}
