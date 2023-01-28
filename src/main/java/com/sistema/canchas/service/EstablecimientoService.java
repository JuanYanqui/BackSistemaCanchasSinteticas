package com.sistema.canchas.service;

import com.sistema.canchas.model.Establecimiento;

import java.util.Optional;

public interface EstablecimientoService extends GenericService <Establecimiento, Long>{
    Optional<Establecimiento> porId(Long idEmpresa);

    Establecimiento porIdPersona(Long idPersona);

    boolean porRuc(String ruc);
}
