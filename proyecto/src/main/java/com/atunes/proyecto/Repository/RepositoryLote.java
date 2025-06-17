package com.atunes.proyecto.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atunes.proyecto.Entity.Lote;

public interface RepositoryLote extends JpaRepository<Lote, Long> {
    List<Lote> findByCodigo_lote(int codigo_lote); // Método para buscar por número de lote
    List<Lote> findByTipo(Lote.tipo tipo); // Método para buscar por tipo de atún
    List<Lote> findByEstado(Lote.Estado estado); // Método para buscar por estado del lote
}
