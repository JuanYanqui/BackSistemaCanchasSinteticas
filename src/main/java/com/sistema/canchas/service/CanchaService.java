package com.sistema.canchas.service;

import com.sistema.canchas.model.Cancha;
import com.sistema.canchas.model.Establecimiento;

import java.util.List;
import java.util.Optional;

public interface CanchaService extends GenericService<Cancha,Long>{


    List<Cancha> listaByEstablecimeinto(Long idEstablecimiento);

    Optional<Cancha> porId(Long idCancha);
}
