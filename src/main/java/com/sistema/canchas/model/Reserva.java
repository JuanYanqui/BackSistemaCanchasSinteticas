package com.sistema.canchas.model;

import lombok.Getter;
import lombok.Setter;


import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "reserva")
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReserva")
    private Long idReserva;
    @Column(name = "fecha_reserva")
    private Date fecha_reserva;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ididDisponibilidad",referencedColumnName = "idDisponibilidad")
    private Disponibilidad disponibilidad;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCliente",referencedColumnName = "idCliente")
    private Cliente cliente;

}
