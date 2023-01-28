package com.sistema.canchas.model;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@Entity
@Table(name = "persona")
public class Persona {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPersona")
    private Long idPersona;

    @Column(name="cedula")
    private String cedula;

    @Column(name="nombre")
    private String nombres;

    @Column(name="apellido")
    private String apellidos;

    @Column(name="fechaNacimiento")
    private Date fechaNacimmiento;

    @Column(name="genero")
    private String genero;

    @Column(name="direccion")
    private String direccion;

    @Column(name="email")
    private String email;

    @Column(name="telefono")
    private String telefono;

    @Column(name="celular")
    private String celular;

    @Column(name="foto")
    private String foto;

    @Column(name="fechaRegistro")
    private Date fechaRegistro;




}
