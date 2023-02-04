package com.sistema.canchas.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "reclamo")
public class Reclamo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReclamo")
    private Long idReclamo;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_reclamo")
    private Date fecha_reclamo;

    @ManyToOne
    @JoinColumn(name = "idCliente",referencedColumnName = "idPersona")
    private Persona cliente;

    @ManyToOne
    @JoinColumn(name = "idAdministrador",referencedColumnName = "idPersona")
    private Persona administrador;
}
