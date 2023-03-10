package com.sistema.canchas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "registro_damage")
public class RegistroDamage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDamage")
    private Long idDamage;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "valor")
    private Double valor;

    @Column(name = "foto")
    private String foto;
    @ManyToOne
    @JoinColumn(name = "idPersona",referencedColumnName = "idPersona")
    private Persona cliente;
    @ManyToOne
    @JoinColumn(name = "idEstablecimiento",referencedColumnName = "idEstablecimiento")
    private Establecimiento establecimiento;


}
