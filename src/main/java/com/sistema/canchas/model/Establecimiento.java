package com.sistema.canchas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "establecimiento")
public class Establecimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idEstablecimiento")
    private Long idEstablecimiento;

    @Column(name="ruc")
    private String ruc;

    @Column(name="nombre")
    private String nombre;

    @Column(name="puntuacion")
    private Integer puntuacion;

    @Column(name="horaApertura")
    private Date horaApertura;

    @Column(name="horaCierre")
    private Date horaCierre;

    @Column(name="bar")
    private Boolean bar;

    @Column(name="vestidores")
    private Boolean vestidores;

    @Column(name="estacionamiento")
    private Boolean estacionamiento;

    @Column(name="banios")
    private Boolean banios;
    @Column(name = "estado")
    private Boolean esatdo;

    @ManyToOne
    @JoinColumn(name = "idPersona",referencedColumnName = "idPersona")
    private Persona administrador;
    @JsonIgnore
    @OneToMany(mappedBy = "establecimiento",cascade = CascadeType.ALL)
    private List<FotoEstablecimiento> fotoEstablecimiento;
    @JsonIgnore
    @OneToMany(mappedBy = "establecimiento",cascade = CascadeType.ALL)
    private List<Cancha> canchas;
    @JsonIgnore
    @OneToMany(mappedBy = "establecimiento",cascade = CascadeType.ALL)
    private List<RegistroDamage> registroDamages;

    @ManyToOne
    @JoinColumn(name = "idBarrio",referencedColumnName = "idBarrio")
    private Barrio barrio;

}
