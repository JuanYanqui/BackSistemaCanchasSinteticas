package com.sistema.canchas.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "reclamo")
public class Reclamo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idReclamo")
    private Long idReclamo;
    @Column(name = "titulo")
    private String titulo;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_reclamo")
    @Temporal(TemporalType.DATE)
    private Date fecha_reclamo;

    private Boolean estado = false;

    @PrePersist
    public void prePersist() {
        fecha_reclamo= new Date();
    }
    @ManyToOne
    @JoinColumn(name = "idCliente",referencedColumnName = "idPersona")
    private Persona cliente;

    @ManyToOne
    @JoinColumn(name = "idAdministrador",referencedColumnName = "idPersona")
    private Persona administrador;
}
