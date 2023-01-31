package com.sistema.canchas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "administrador")
public class Administrador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idAdministrador")
    private Long idAdministrador;

    @Column(name="entidad_bancaria")
    private String entidad_bancaria;

    @Column(name="n_cuenta_bancaria")
    private String n_cuenta_bancaria;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idPersona",referencedColumnName ="idPersona")
    private Persona persona;

    @JsonIgnore
    @OneToMany(mappedBy = "administrador",cascade = CascadeType.ALL)
    private List<Establecimiento> establecimiento;

    @OneToMany(mappedBy = "administrador")
    private List<Reclamo> reclamos;
}
