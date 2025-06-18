package com.atunes.proyecto.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atunes.proyecto.Entity.Roles;
import com.atunes.proyecto.Repository.RepositoryRoles;

import jakarta.transaction.Transactional;

@Service
public class RolesService {

    @Autowired
    public RepositoryRoles repositoryRoles;

    //Listar todos los roles
    @Transactional
    public List<Roles> listarTodosLosRoles(){
        return repositoryRoles.findAll();
    }
    //eliminar rol 
    @Transactional
    public void eliminarRol(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo.");
        }
        if (!repositoryRoles.existsById(id)) {
            throw new IllegalArgumentException("No se encontró un rol con ID " + id);
        }
        repositoryRoles.deleteById(id);
    }

    //guardar o actualizar
    @Transactional
    public Roles guardarRol(Roles rol) {
        if (rol == null || rol.getTipo_rol() == null || rol.getTipo_rol().trim().isEmpty()) {
            throw new IllegalArgumentException("El rol debe tener un nombre válido.");
        }
        return repositoryRoles.save(rol);
    }
}
