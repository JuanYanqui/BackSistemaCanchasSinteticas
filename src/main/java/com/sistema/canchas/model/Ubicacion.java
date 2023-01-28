package com.sistema.canchas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Setter
@Getter
@Table(name = "ubicacion")
public class Ubicacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUbicacion;
    @Column(name = "calle_principal")
    private String calle_principal;
    @Column(name = "calle_securndaria")
    private String calle_secundaria;
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "numero")
    private String numero;
    @ManyToOne
    @JoinColumn(name = "idBarrio",referencedColumnName = "idBarrio")
    private Barrio barrio;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEstablecimiento",referencedColumnName = "idEstablecimiento")
    private Establecimiento establecimiento;

}
