package com.atunes.proyecto.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atunes.proyecto.Entity.Producto_lote;

public interface RepositoryProductoLote extends JpaRepository<Producto_lote, Long> {
    List<Producto_lote> findById(int id); // Método para buscar por ID de producto

}
