package com.atunes.proyecto.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atunes.proyecto.Entity.Usuario;

public interface RepositoryUsuario extends JpaRepository<Usuario, Long> {
    List<Usuario> findByNombre(String nombre);
}
