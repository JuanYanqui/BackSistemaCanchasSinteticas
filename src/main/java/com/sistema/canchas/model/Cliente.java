package com.sistema.canchas.model;

import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "cliente")
public class Cliente {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idCliente")
    private Long idCliente;

    @Column(name="lista_Negra")
    private boolean lista_Negra;

    @OneToOne
    @JoinColumn(name="idPersona",referencedColumnName ="idPersona")
    private Persona persona;

    @OneToMany(mappedBy = "cliente")
    private List<Reclamo> reclamo;

    @OneToMany(mappedBy = "cliente")
    private List<Registro_Damage> registroDamages;

    @OneToMany(mappedBy = "cliente")
    private List<Pago> pagos;

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;

}
