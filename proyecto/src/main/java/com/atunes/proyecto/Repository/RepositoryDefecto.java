package com.atunes.proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atunes.proyecto.Entity.Defecto;
import java.util.List;


public interface RepositoryDefecto extends JpaRepository<Defecto, Long> {
    List<Defecto> findByDescripcion(String descripcion); // Método para buscar por descripción    
}
