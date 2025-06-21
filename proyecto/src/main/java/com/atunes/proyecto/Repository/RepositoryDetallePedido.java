package com.atunes.proyecto.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atunes.proyecto.Entity.DetallePedido;

public interface RepositoryDetallePedido extends JpaRepository<DetallePedido, Long> {
    List<DetallePedido> findByPedidoId(Long pedidoId); // Método para buscar por ID de pedido
}
