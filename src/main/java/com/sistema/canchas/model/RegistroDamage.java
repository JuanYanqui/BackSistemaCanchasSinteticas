package com.sistema.canchas.model;

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
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCliente",referencedColumnName = "idCliente")
    private Cliente cliente;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEstablecimiento",referencedColumnName = "idEstablecimiento")
    private Establecimiento establecimiento;

    @OneToMany(mappedBy = "registroDamage")
    private List<FotoDamage> fotoDamages;

    @OneToMany(mappedBy = "registroDamage")
    private List<Pago> pagos;
}
