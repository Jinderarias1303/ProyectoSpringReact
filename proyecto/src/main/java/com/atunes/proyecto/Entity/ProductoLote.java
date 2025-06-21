package com.atunes.proyecto.Entity;


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
@Table(name = "productoLote")
public class ProductoLote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "idProducto", referencedColumnName = "id")
    private Producto idProducto;

    @ManyToOne
    @JoinColumn(name = "idLote", referencedColumnName = "id")
    private Lote idLote;

    private int cantidadProducida;
    

}
