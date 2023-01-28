package com.sistema.canchas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "usuario")
public class Usuario {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idUsuario")
    private Long idUsuario;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="estado")
    private boolean estado;

    @Column(name="foto")
    private String foto;

    @ManyToOne
    @JoinColumn(name="idPersona",referencedColumnName ="idPersona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name="idEstablecimiento",referencedColumnName ="idEstablecimiento")
    private Establecimiento establecimiento;

    @ManyToOne
    @JoinColumn(name="idRol",referencedColumnName ="idRol")
    private Rol rol;





}
