package com.sistema.canchas.service;

import com.sistema.canchas.model.Reclamo;

import java.util.Optional;

public interface ReclamoService extends GenericService<Reclamo,Long>{
    Optional<Reclamo> porId(Long idReclamo);
}
