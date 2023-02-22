package com.sistema.canchas.service;

import com.sistema.canchas.model.Cancha;
import com.sistema.canchas.model.Establecimiento;
import com.sistema.canchas.model.Persona;

import java.util.List;
import java.util.Optional;

public interface EstablecimientoService extends GenericService<Establecimiento,Long>{
    Establecimiento Ruc(String ruc);

    Optional<Establecimiento> porId(Long idEstablecimiento);

    List<Establecimiento> listarByPersona(Long idPersona);

    List<Establecimiento> findByPersona(Persona persona);

}
