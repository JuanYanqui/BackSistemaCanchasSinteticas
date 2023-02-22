package com.sistema.canchas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;
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
    @Column(name = "horainicio")
    private LocalDateTime horainicio;

    @Column(name = "horafin")
    private LocalDateTime  horafin;


    @ManyToOne
    @JoinColumn(name = "idCancha",referencedColumnName = "idCancha")
    private Cancha cancha;

    @JsonIgnore
    @OneToMany(mappedBy = "disponibilidad",cascade = CascadeType.ALL)
    private List<Reserva> reserva;
}
