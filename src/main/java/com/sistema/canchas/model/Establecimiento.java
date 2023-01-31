package com.sistema.canchas.model;

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
    private static final long serialVersionUID = 1L;
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
    @JoinColumn(name = "idAdministrador",referencedColumnName = "idAdministrador")
    private Administrador administrador;

    @OneToOne(mappedBy = "establecimiento")
    private Ubicacion ubicacion;

    @OneToMany(mappedBy = "establecimiento")
    private List<FotoEstablecimiento> fotoEstablecimiento;

    @OneToMany(mappedBy = "establecimiento")
    private List<Cancha> canchas;

    @OneToMany(mappedBy = "establecimiento")
    private List<RegistroDamage> registroDamages;

}
