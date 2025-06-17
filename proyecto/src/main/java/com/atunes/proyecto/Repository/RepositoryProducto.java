package com.atunes.proyecto.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atunes.proyecto.Entity.Producto;

public interface RepositoryProducto extends JpaRepository<Producto, Long> {
    List<Producto> findByNombre(String nombre); // Método para buscar por nombre del producto
}
