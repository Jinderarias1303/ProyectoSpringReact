package com.atunes.proyecto.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atunes.proyecto.Entity.Cliente;
import com.atunes.proyecto.Repository.RepositoryCliente;

import org.springframework.transaction.annotation.Transactional;

@Service
public class ClienteService {
    @Autowired
    private RepositoryCliente repositoryCliente;

    @Transactional (readOnly = true)
    public List<Cliente> listarTodosLosClientes() {
        return repositoryCliente.findAll();
    } // Listar todos los clientes

    @Transactional (readOnly = true)
    public Optional<Cliente> buscarClientePorId(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("el id no puede ser nulo"); 
        }
        return repositoryCliente.findById(id);    
    } // Buscar cliente por ID

    @Transactional (readOnly = false)
    public Cliente guardarCliente(Cliente cliente) {
        return repositoryCliente.save(cliente);
    } // Guardar cliente

    @Transactional (readOnly = false)
    public void eliminarCliente(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("el id no puede ser nulo para eliminar un cliente");
        }if (!repositoryCliente.existsById(id)) {
            throw new IllegalArgumentException("el id"+ id + " no existe");
        }
        repositoryCliente.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<Cliente> buscarClientesPorIdentificacion(String identificacion) {
        if (identificacion == null || identificacion.isBlank()) {
            throw new IllegalArgumentException("La identificación no puede ser nula o vacía");
        }

        List<Cliente> clientes = repositoryCliente.findByIdentificacionContainingIgnoreCase(identificacion);

        if (clientes.isEmpty()) {
            throw new IllegalArgumentException("No se encontró ningún cliente con la identificación: " + identificacion);
        }

        return clientes;
    }
}

