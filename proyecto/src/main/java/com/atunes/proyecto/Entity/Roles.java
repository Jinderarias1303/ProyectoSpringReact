package com.atunes.proyecto.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType; // Importa EnumType
import jakarta.persistence.Enumerated; // Importa Enumerated
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import com.atunes.proyecto.enums.TipoRol; // **NUEVO:** Importa el Enum TipoRol

@Data
@Entity
@Table(name = "roles")
public class Roles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING) // **CAMBIO CRUCIAL:** Mapea el Enum de Java a un String en la DB
    private TipoRol tipoRol; // **CAMBIO CRUCIAL:** Ahora es de tipo TipoRol (tu Enum), no String
}