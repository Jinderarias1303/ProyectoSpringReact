package com.atunes.proyecto.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atunes.proyecto.Entity.Pedido;
import com.atunes.proyecto.Entity.Pedido.EstadoEntrega;
import com.atunes.proyecto.Repository.RepositoryPedido;

import org.springframework.transaction.annotation.Transactional;
@Service    
public class PedidoService {

    @Autowired
    private RepositoryPedido repositoryPedido;

    //listar todos los Pedidos
    @Transactional(readOnly = true)
    public List<Pedido> listarTodosLosPedidos(){
        return repositoryPedido.findAll();
    }

    //buscar pedido por ID
    @Transactional(readOnly = true)
    public Optional<Pedido> buscarPorId(Long id){
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo");
        }
        return repositoryPedido.findById(id);
    }
    
    // guardar o actualizar un pedido
    @Transactional
    public Pedido guardarPedido(Pedido pedido){
        if (pedido == null) {
            throw new IllegalArgumentException("El pedido no puede ser nulo.");
        }
        return repositoryPedido.save(pedido);
    }

    //Eliminar Pedido Por ID
    @Transactional
    public void eliminarPedido(Long id){
        if (id == null) {
            throw new IllegalArgumentException("El ID no puede ser nulo para eliminar un lote.");
        }if (!repositoryPedido.existsById(id)) {
            throw new IllegalArgumentException("El ID " + id + " no existe.");
        }
        repositoryPedido.deleteById(id);
    }

    //Buscar pedidos por EstadoEntrega
    @Transactional(readOnly = true)
    public List<Pedido> buscarPorEstadoEntrega(String estado_entrega){
        EstadoEntrega tipoEnum;
        try {
            tipoEnum = EstadoEntrega.valueOf(estado_entrega);
        } catch (IllegalArgumentException | NullPointerException e) {
            throw new IllegalArgumentException("Estado de entrega inválido: " + estado_entrega, e);
        }
        return repositoryPedido.findByEstadoEntrega(tipoEnum.name());
    }

}
