package com.sistema.canchas.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "disponibilidad")
public class Disponibilidad {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDisponibilidad")
    private Long idDisponibilidad;
    @Column(name = "hora")
    private Date hora;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCancha",referencedColumnName = "idCancha")
    private Cancha cancha;

    @OneToMany(mappedBy = "disponibilidad")
    private List<Reserva> reserva;
}
