package com.atunes.proyecto.Entity;

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
@Table(name = "clientes")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom_cliente_empresa;

    @Column(unique = true) 
    private int identificacion;

    private String correo;
    private String telefono;
    private String direccion;

    public enum estado {
        Activo,
        Inactivo,
    }

    @Enumerated(EnumType.STRING) // esto es para que se guarde el nombre del enum en la base de datos como string
    private estado estado;
}
