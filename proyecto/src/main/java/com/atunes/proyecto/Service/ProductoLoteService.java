package com.atunes.proyecto.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atunes.proyecto.Entity.ProductoLote;
import com.atunes.proyecto.Repository.RepositoryProductoLote;

import jakarta.transaction.Transactional;

@Service
public class ProductoLoteService {

    @Autowired
    private RepositoryProductoLote repositoryProductoLote;

    // Listar todos los registros de producto-lote
    @Transactional
    public List<ProductoLote> listarTodos() {
        return repositoryProductoLote.findAll();
    }

    // Buscar por ID
    @Transactional
    public Optional<ProductoLote> buscarPorId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        }
        return repositoryProductoLote.findById(id);
    }

    // Guardar o actualizar producto-lote
    @Transactional
    public ProductoLote guardar(ProductoLote productoLote) {
        if (productoLote == null) {
            throw new IllegalArgumentException("El producto-lote no puede ser nulo.");
        }
        return repositoryProductoLote.save(productoLote);
    }

    // Eliminar por ID
    @Transactional
    public void eliminarPorId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        }
        if (!repositoryProductoLote.existsById(id)) {
            throw new IllegalArgumentException("No existe un registro con ID: " + id);
        }
        repositoryProductoLote.deleteById(id);
    }
}
