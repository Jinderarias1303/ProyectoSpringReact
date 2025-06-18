package com.atunes.proyecto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.atunes.proyecto.Entity.Defecto;
import com.atunes.proyecto.Repository.RepositoryDefecto;

@Service
public class DefectoService {

    @Autowired
    private RepositoryDefecto repositoryDefecto;

    // Listar todos los defectos
    @Transactional(readOnly = true)
    public List<Defecto> listarTodosLosDefectos() {
        return repositoryDefecto.findAll();
    }

    // Eliminar defecto por ID
    @Transactional
    public void eliminarDefecto(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo para eliminar.");
        }
        if (!repositoryDefecto.existsById(id)) {
            throw new IllegalArgumentException("El ID " + id + " no existe.");
        }
        repositoryDefecto.deleteById(id);
    }

    // Crear o actualizar un defecto
    @Transactional
    public Defecto guardarDefecto(Defecto defecto) {
        if (defecto == null || defecto.getDescripcion() == null || defecto.getDescripcion().trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción del defecto no puede estar vacía.");
        }
        return repositoryDefecto.save(defecto);
    }
    
}
