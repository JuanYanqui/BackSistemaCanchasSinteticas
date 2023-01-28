package com.sistema.canchas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Entity
@Table(name = "foto_establecimiento")
public class Foto_Establecimiento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idFoto")
    private Long idFoto;
    @Column(name = "foto")
    private String foto;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEstablecimiento",referencedColumnName = "idEstablecimiento")
    private Establecimiento establecimiento;
}
