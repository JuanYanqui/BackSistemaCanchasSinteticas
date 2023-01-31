package com.sistema.canchas.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Setter
@Getter
@Table(name = "pago")
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPago")
    private Long idPago;
    @Column(name = "foto")
    private String foto;
    @Column(name = "fecha_pago")
    private Date fecha_pago;
    @Column(name = "estado")
    private Boolean estado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idDamage",referencedColumnName = "idDamage")
    private RegistroDamage registroDamage;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCliente",referencedColumnName = "idCliente")
    private Cliente cliente;

    @OneToOne(mappedBy = "pago")
    private Comprobante comprobante;
}
