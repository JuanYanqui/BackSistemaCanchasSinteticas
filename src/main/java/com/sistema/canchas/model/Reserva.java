package com.sistema.canchas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

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
    //Relaciones con tablas
    @ManyToOne
    @JoinColumn(name = "idDisponibilidad",referencedColumnName = "idDisponibilidad")
    private Disponibilidad disponibilidad;

    @ManyToOne
    @JoinColumn(name = "idPersona",referencedColumnName = "idPersona")
    private Persona cliente;

    @JsonIgnore
    @OneToMany(mappedBy = "reserva",cascade = CascadeType.ALL)
    private List<PagoReserva> pagoReservas;

    @JsonIgnore
    @OneToMany(mappedBy = "reserva",cascade = CascadeType.ALL)
    private List<Blacklist> blacklists;
}
