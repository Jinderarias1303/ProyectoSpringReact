package com.atunes.proyecto.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atunes.proyecto.Entity.Cliente;

public interface RepositoryCliente extends JpaRepository<Cliente, Long> {


}
