package com.sistema.canchas.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "pago_damage")
public class PagoDamage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPago")
    private Long idPago;
    @Column(name = "foto")
    private String foto;
    @Column(name = "fecha_pago")
    private Date fecha_pago;
    @Column(name = "estado")
    private String estado;

    @OneToOne
    @JoinColumn(name = "idDamage",referencedColumnName = "idDamage")
    private RegistroDamage registroDamage;


}
