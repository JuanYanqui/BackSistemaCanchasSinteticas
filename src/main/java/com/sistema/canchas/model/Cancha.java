package com.sistema.canchas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "cancha")
public class Cancha {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCancha")
    private Long idCancha;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "ancho")
    private Double ancho;
    @Column(name = "altura")
    private Double altura;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "tarifa")
    private Double tarifa;
    @ManyToOne
    @JoinColumn(name = "idEstablecimiento",referencedColumnName = "idEstablecimiento")
    private Establecimiento establecimiento;

    @JsonIgnore
    @OneToMany(mappedBy = "cancha",cascade = CascadeType.ALL)
    private List<Disponibilidad> disponibilidad;

}
