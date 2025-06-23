package com.atunes.proyecto.Entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "detallePedidos")
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_pedido", referencedColumnName = "id")
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_producto", referencedColumnName = "id")
    private Producto producto;

    private int cantidad;
    private BigDecimal subtotal;
    

}
