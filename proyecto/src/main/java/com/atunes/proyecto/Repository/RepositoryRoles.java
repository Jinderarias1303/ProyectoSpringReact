package com.atunes.proyecto.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atunes.proyecto.Entity.Roles;

public interface RepositoryRoles extends JpaRepository<Roles, Long> {
    List<Roles> findByTipoRol(String tipoRol);
}
