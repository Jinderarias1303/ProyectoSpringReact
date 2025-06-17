package com.atunes.proyecto.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atunes.proyecto.Entity.Lote_defectuoso;

public interface RepositoryLoteDefectuoso extends JpaRepository<Lote_defectuoso, Long> {
    List<Lote_defectuoso> findByIdLote(int id); // Método para buscar por ID de lote defectuoso
}
