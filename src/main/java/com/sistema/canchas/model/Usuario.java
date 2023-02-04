package com.sistema.canchas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "usuario")
public class Usuario {

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
    //Relaciones con tablas
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idPersona",referencedColumnName ="idPersona")
    private Persona persona;

    @ManyToOne
    @JoinColumn(name = "idRol",referencedColumnName = "idRol")
    private Rol rol;




}
