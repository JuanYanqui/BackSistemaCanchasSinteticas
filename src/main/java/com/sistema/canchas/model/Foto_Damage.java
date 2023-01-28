package com.sistema.canchas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "foto_damage")
public class Foto_Damage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFoto")
    private Long idFoto;
    @Column(name = "foto")
    private String foto;

    @ManyToOne
    @JoinColumn(name = "idDamage",referencedColumnName = "idDamage")
    private Registro_Damage registroDamage;
}
