package com.atunes.proyecto.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atunes.proyecto.Entity.Lote;
import com.atunes.proyecto.Repository.RepositoryLote;

import org.springframework.transaction.annotation.Transactional;

@Service
public class LoteService {

    @Autowired
    private RepositoryLote repositoryLote;

    // Listar todos los lotes
    @Transactional(readOnly = true)
    public List<Lote> listarTodosLosLotes() {
        return repositoryLote.findAll();
    }

    // Buscar lote por ID
    @Transactional(readOnly = true)
    public Optional<Lote> buscarLotePorId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        }
        return repositoryLote.findById(id);
    }

    // Guardar o actualizar un lote
    @Transactional
    public Lote guardarLote(Lote lote) {
        if (lote == null) {
            throw new IllegalArgumentException("El lote no puede ser nulo.");
        }
        return repositoryLote.save(lote);
    }

    // Eliminar lote por ID
    @Transactional
    public void eliminarLote(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo para eliminar un lote.");
        }
        if (!repositoryLote.existsById(id)) {
            throw new IllegalArgumentException("El ID " + id + " no existe.");
        }
        repositoryLote.deleteById(id);
    }

    // Buscar lotes por estado
    @Transactional(readOnly = true)
    public List<Lote> buscarLotesPorEstado(String estado) {
        Lote.Estado estadoEnum;
        try {
            estadoEnum = Lote.Estado.valueOf(estado);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new IllegalArgumentException("Estado inválido: " + estado);
        }
        return repositoryLote.findByEstado(estadoEnum);
    }


    // Buscar lotes por tipo
    @Transactional(readOnly = true)
    public List<Lote> buscarLotesPorTipo(String tipo) {
        Lote.tipo tipoEnum;
        try {
            tipoEnum = Lote.tipo.valueOf(tipo);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new IllegalArgumentException("Tipo inválido: " + tipo);
        }
        return repositoryLote.findByTipo(tipoEnum);
    }
}
