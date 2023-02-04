package com.sistema.canchas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;

import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRol;
    private String nombre;
    private String descripcion;
    //Relaciones con tablas
    @JsonIgnore
    @OneToMany(mappedBy = "rol",cascade = CascadeType.ALL)
    private List<Usuario> usuario;
}
