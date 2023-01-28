package com.sistema.canchas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "establecimiento")
public class Establecimiento {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEstablecimiento")
    private Long idEstablecimiento;

    @Column(name="ruc")
    private String ruc;

    @Column(name="nombre")
    private String nombre;

    @Column(name="ubicacion")
    private String ubicacion;

    @Column(name="puntuacion")
    private Integer puntuacion;

    @Column(name="horaApertura")
    private Date horaApertura;

    @Column(name="horaCierre")
    private Date horaCierre;

    @Column(name="bar")
    private boolean bar;

    @Column(name="vestidores")
    private boolean vestidores;

    @Column(name="estacionamiento")
    private boolean estacionamiento;

    @Column(name="banios")
    private boolean banios;

    @ManyToOne
    @JoinColumn(name="idPersona",referencedColumnName ="idPersona")
    private Persona persona;

}
