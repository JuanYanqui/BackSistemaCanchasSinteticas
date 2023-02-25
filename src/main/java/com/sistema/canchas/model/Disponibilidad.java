package com.sistema.canchas.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.time.LocalDate;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha;

    @Column(name = "horafin")
    private Integer  hora;


    @ManyToOne
    @JoinColumn(name = "idCancha",referencedColumnName = "idCancha")
    private Cancha cancha;

    @JsonIgnore
    @ManyToOne
    private Reserva reserva;
}
