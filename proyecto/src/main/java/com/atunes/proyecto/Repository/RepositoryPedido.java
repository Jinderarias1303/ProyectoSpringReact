package com.atunes.proyecto.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.atunes.proyecto.Entity.Pedido;

public interface RepositoryPedido extends JpaRepository<Pedido, Long> {
    List<Pedido> findByidCliente(Long idCliente);  // Método para buscar pedidos por ID de cliente
    List<Pedido> findByEstadoEntrega(String estadoEntrega); // Método para buscar pedidos por estado de entrega
}
