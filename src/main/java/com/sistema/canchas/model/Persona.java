package com.sistema.canchas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idPersona")
    private Long idPersona;

    @Column(name="cedula")
    private String cedula;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="fechaNacimiento")
    private LocalDate fechaNacimmiento;

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
    private LocalDate fechaRegistro;

    @Column(name = "entidad_bancaria")
    private String entidad_bancaria;

    @Column(name = "numero_cuenta")
    private String numero_cuenta;
    //Relaciones con tablas

    @JsonIgnore
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<Reclamo> reclamo;

    @JsonIgnore
    @OneToMany(mappedBy = "administrador",cascade = CascadeType.ALL)
    private List<Reclamo> reclamos;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<Reserva> reservas;

    @JsonIgnore
    @OneToMany(mappedBy = "administrador",cascade = CascadeType.ALL)
    private List<Establecimiento> establecimiento;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<RegistroDamage> registroDamages;

}
