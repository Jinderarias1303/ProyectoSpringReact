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
@Table(name = "loteDefectuoso")
public class LoteDefectuoso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_lote", referencedColumnName = "id")
    private Lote idLote;

    @ManyToOne
    @JoinColumn(name = "id_defecto", referencedColumnName = "id")
    private Defecto idDefecto;
}
