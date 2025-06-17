package com.atunes.proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atunes.proyecto.Entity.Cliente;
import com.atunes.proyecto.Entity.Cliente.estado;

import java.util.List;


public interface RepositoryCliente extends JpaRepository<Cliente, Long> {
    List<Cliente> findByIdentificacion(int identificacion); // Método para buscar por identificación
    List<Cliente> findByEstado(estado estado); // Método para buscar por estado  Inactivo o Activo
    
}
