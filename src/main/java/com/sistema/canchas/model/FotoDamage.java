package com.sistema.canchas.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "foto_damage")
public class FotoDamage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFoto")
    private Long idFoto;
    @Column(name = "foto")
    private String foto;

    @ManyToOne
    @JoinColumn(name = "idDamage",referencedColumnName = "idDamage")
    private RegistroDamage registroDamage;
}
