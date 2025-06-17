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
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id")
    private Cliente id_cliente;

    private int precio_total;

    public enum EstadoEntrega {
        Pendiente,
        En_proceso,
        Entregado,
        Cancelado
    }
    @Enumerated(EnumType.STRING)
    private EstadoEntrega estado_entrega;

    private Date fecha_entrega;
    private Date fecha_pedido;

}
