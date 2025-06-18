package com.atunes.proyecto.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atunes.proyecto.Entity.Lote_defectuoso;
import com.atunes.proyecto.Repository.RepositoryLoteDefectuoso;

import jakarta.transaction.Transactional;

@Service
public class LoteDefectuosoService {

    @Autowired
    private RepositoryLoteDefectuoso repositoryLoteDefectuoso;

    // Listar todos los lotes defectuosos
    @Transactional
    public List<Lote_defectuoso> listarTodos() {
        return repositoryLoteDefectuoso.findAll();
    }

    // Buscar por ID
    @Transactional
    public Optional<Lote_defectuoso> buscarPorId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        }
        return repositoryLoteDefectuoso.findById(id);
    }

    // Guardar o actualizar lote defectuoso
    @Transactional
    public Lote_defectuoso guardar(Lote_defectuoso loteDefectuoso) {
        if (loteDefectuoso == null) {
            throw new IllegalArgumentException("El lote defectuoso no puede ser nulo.");
        }
        return repositoryLoteDefectuoso.save(loteDefectuoso);
    }

    // Eliminar por ID
    @Transactional
    public void eliminarPorId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        }
        if (!repositoryLoteDefectuoso.existsById(id)) {
            throw new IllegalArgumentException("No existe un lote defectuoso con ID: " + id);
        }
        repositoryLoteDefectuoso.deleteById(id);
    }
}
