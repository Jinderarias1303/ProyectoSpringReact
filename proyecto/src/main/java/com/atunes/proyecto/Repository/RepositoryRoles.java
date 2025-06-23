package com.atunes.proyecto.Repository;

import java.util.Optional; // Si quieres buscar por tipoRol, necesitarás Optional
import org.springframework.data.jpa.repository.JpaRepository;
import com.atunes.proyecto.Entity.Roles;
import com.atunes.proyecto.enums.TipoRol; // Para el método findByTipoRol

public interface RepositoryRoles extends JpaRepository<Roles, Long> {
    // Si necesitas buscar un rol por su tipo (enum), puedes añadir este método:
    Optional<Roles> findByTipoRol(TipoRol tipoRol);
}