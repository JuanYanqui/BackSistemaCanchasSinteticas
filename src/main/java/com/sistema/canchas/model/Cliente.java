package com.sistema.canchas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="idPersona",referencedColumnName ="idPersona")
    private Persona persona;
    @JsonIgnore
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<Reclamo> reclamo;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<RegistroDamage> registroDamages;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<Pago> pagos;

    @JsonIgnore
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL)
    private List<Reserva> reservas;

}
