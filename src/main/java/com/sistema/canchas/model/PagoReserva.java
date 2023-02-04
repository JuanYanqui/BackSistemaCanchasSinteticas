package com.sistema.canchas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "pago_reserva")
public class PagoReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idPagoReserva")
    private Long idReserva;
    @Column(name = "foto")
    private String foto;
    @Column(name = "estado")
    private String estado;
    @Column(name = "fecha_pago")
    private LocalDate fecha_pago;
    //Relaciones con tablas
    @ManyToOne
    @JoinColumn(name = "idReserva",referencedColumnName = "idReserva")
    private Reserva reserva;

}
