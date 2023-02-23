package com.sistema.canchas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
