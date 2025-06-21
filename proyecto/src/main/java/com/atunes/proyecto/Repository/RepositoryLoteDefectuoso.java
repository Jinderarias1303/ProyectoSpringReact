package com.atunes.proyecto.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atunes.proyecto.Entity.LoteDefectuoso;

public interface RepositoryLoteDefectuoso extends JpaRepository<LoteDefectuoso, Long> {
    List<LoteDefectuoso> findByIdLoteDefectuoso(Long id); // Método para buscar por ID de lote defectuoso
}
