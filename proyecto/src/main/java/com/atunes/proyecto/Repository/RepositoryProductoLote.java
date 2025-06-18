package com.atunes.proyecto.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atunes.proyecto.Entity.ProductoLote;

public interface RepositoryProductoLote extends JpaRepository<ProductoLote, Long> {
    List<ProductoLote> findById(int id); // Método para buscar por ID de producto

}
