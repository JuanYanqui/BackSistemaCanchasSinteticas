package com.sistema.canchas.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "comprobante")
public class Comprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idComprobante")
    private Long idComprobante;
    @Column(name = "fecha")
    private Date fecha;
    @Column(name="total")
    private Double total;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPago",referencedColumnName = "idPago")
    private Pago pago;

}
