package com.atunes.proyecto.Entity;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pedido")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idCliente", referencedColumnName = "id") // nombre de la columna FK
    private Cliente cliente;

    private int precioTotal;

    public enum EstadoEntrega {
        Pendiente,
        En_proceso,
        Entregado,
        Cancelado
    }

    @Enumerated(EnumType.STRING)
    private EstadoEntrega estadoEntrega;

    private Date fechaEntrega;
    private Date fechaPedido;
}
