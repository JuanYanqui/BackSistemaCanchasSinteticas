package com.sistema.canchas.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "ubicacion")
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idUbicacion")
    private Long idUbicacion;
    @Column(name = "calle_principal")
    private String calle_principal;
    @Column(name = "calle_securndaria")
    private String calle_secundaria;
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "numero_casa")
    private String numero;
    @Column(name = "latitud")
    private String latitud;
    @Column(name = "longitud")
    private String longitud;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idEstablecimiento",referencedColumnName = "idEstablecimiento")
    private Establecimiento establecimiento;

}
