package com.atunes.proyecto.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.atunes.proyecto.Entity.Detalle_pedido;

public interface RepositoryDetallePedido extends JpaRepository<Detalle_pedido, Long> {
    List<Detalle_pedido> findByPedidoId(Long pedidoId); // Método para buscar por ID de pedido
}
