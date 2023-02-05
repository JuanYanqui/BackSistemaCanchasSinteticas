package com.sistema.canchas.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "blacklist")
public class Blacklist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBlacklist")
    private Long idBlacklist;
    @Column(name = "decripcion")
    private String descripcion;
    @Column(name = "fecha_reserva")
    private LocalDate fecha_reserva;
    @Column(name = "hora")
    private Date hora;
    //Relaciones de tablas
    @ManyToOne
    @JoinColumn(name = "idReserva",referencedColumnName = "idReserva")
    private Reserva reserva;

}
