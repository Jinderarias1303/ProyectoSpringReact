package com.atunes.proyecto.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atunes.proyecto.Entity.Producto;
import com.atunes.proyecto.Repository.RepositoryProducto;

@Service
public class ProductoService {

    @Autowired
    private RepositoryProducto repositoryProducto;

    // Listar todos los productos
    @Transactional(readOnly = true)
    public List<Producto> listarTodosLosProductos() {
        return repositoryProducto.findAll();
    }
    
    // Guardar o actualizar producto
    @Transactional
    public Producto guardarProducto(Producto producto) {
        if (producto == null || producto.getNombre_producto() == null || producto.getNombre_producto().isEmpty()) {
            throw new IllegalArgumentException("El producto debe tener un nombre válido.");
        }
        if (producto.getPrecio() == null || producto.getPrecio().doubleValue() < 0) {
            throw new IllegalArgumentException("El precio debe ser válido y no negativo.");
        }
        return repositoryProducto.save(producto);
    }

    // Eliminar producto por ID
    @Transactional
    public void eliminarProducto(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo para eliminar.");
        }
        if (!repositoryProducto.existsById(id)) {
            throw new IllegalArgumentException("El ID " + id + " no existe.");
        }
        repositoryProducto.deleteById(id);
    }

    // Buscar producto por ID
    @Transactional(readOnly = true)
    public Optional<Producto> buscarPorId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        }
        return repositoryProducto.findById(id);
    }
}
