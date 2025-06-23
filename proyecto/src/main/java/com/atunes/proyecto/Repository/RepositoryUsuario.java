package com.atunes.proyecto.Repository;

import java.util.Optional; // **CAMBIO:** Importa Optional
import org.springframework.data.jpa.repository.JpaRepository;
import com.atunes.proyecto.Entity.Usuario;

public interface RepositoryUsuario extends JpaRepository<Usuario, Long> {
    Optional<Usuario> findByUsername(String username); // **CAMBIO:** Devuelve Optional<Usuario>
}