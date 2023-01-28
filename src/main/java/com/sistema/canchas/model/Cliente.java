package com.sistema.canchas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "cliente")
public class Cliente {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCliente")
    private Long idCliente;

    @Column(name="lista_Negra")
    private boolean lista_Negra;

    @OneToOne
    @JoinColumn(name="idPersona",referencedColumnName ="idPersona")
    private Persona persona;
}
