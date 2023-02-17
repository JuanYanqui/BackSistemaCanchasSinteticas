package com.sistema.canchas.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

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


    public boolean getEstado() {
        return estado;
    }
}
