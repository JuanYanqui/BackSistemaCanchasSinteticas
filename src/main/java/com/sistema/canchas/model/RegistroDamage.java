package com.sistema.canchas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "registro_damage")
public class RegistroDamage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idDamage")
    private Long idDamage;
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "valor")
    private Double valor;
    @ManyToOne
    @JoinColumn(name = "idCliente",referencedColumnName = "idCliente")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "idEstablecimiento",referencedColumnName = "idEstablecimiento")
    private Establecimiento establecimiento;

    @JsonIgnore
    @OneToMany(mappedBy = "registroDamage",cascade = CascadeType.ALL)
    private List<FotoDamage> fotoDamages;

    @JsonIgnore
    @OneToMany(mappedBy = "registroDamage",cascade = CascadeType.ALL)
    private List<Pago> pagos;
}
