package com.sistema.canchas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "barrio")
public class Barrio {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idBarrio")
    private Long idBarrio;

    @Column(name = "nombre")
    private Long nombre;
    @JsonIgnore
    @OneToMany(mappedBy = "barrio",cascade = CascadeType.ALL)
    private List<Ubicacion> ubicacion;



}
