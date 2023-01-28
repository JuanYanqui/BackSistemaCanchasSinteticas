package com.sistema.canchas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "administrador")
public class Administrador {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idAdministrador")
    private Long idAdministrador;

    @Column(name="entidad_bancaria")
    private String entidad_bancaria;

    @Column(name="n_cuenta_bancaria")
    private String n_cuenta_bancaria;

    @OneToOne
    @JoinColumn(name="idPersona",referencedColumnName ="idPersona")
    private Persona persona;
}
