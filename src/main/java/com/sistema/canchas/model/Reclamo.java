package com.sistema.canchas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "reclamo")
public class Reclamo {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReclamo;
    private String titulo;
    private String descripcion;
    private Date fecha_reclamo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCliente",referencedColumnName = "idCliente")
    private Cliente cliente;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idAdministrador",referencedColumnName = "idAdministrador")
    private Administrador administrador;
}
