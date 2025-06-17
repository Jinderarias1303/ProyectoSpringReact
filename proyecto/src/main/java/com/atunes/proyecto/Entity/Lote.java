package com.atunes.proyecto.Entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "lotes")
public class Lote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)  // se pone para que el codigo_lote sea unico
    private int codigo_lote;
    private Date fecha_produccion;

    public enum tipo{
        atun_en_aceite,
        atun_en_agua,
        atun_en_salsa,
    }
    @Enumerated(EnumType.STRING)  // esto es para que se guarde el nombre del enum en la base de datos como string
    private tipo Tipo;

    private int cantidad_producida;

    public enum Estado{
        Disponible,
        vendido,
        Defectuoso,
    }
    @Enumerated(EnumType.STRING)
    private Estado estado;
}
