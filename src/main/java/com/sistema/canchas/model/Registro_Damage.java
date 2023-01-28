package com.sistema.canchas.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "registro_damage")
public class Registro_Damage {
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
    private List<Foto_Damage> fotoDamages;

    @OneToMany(mappedBy = "registroDamage")
    private List<Pago> pagos;
}
