package com.sistema.canchas.service;

import com.sistema.canchas.model.Reclamo;

import java.util.Optional;

import com.sistema.canchas.model.Reclamo;

import java.util.List;
import java.util.Optional;

public interface ReclamoService extends GenericService<Reclamo,Long>{
    Optional<Reclamo> porId(Long idReclamo);

    List<Reclamo> listarByReclamos(Long idPersona);

    List<Reclamo> listarByReclamosCliente(Long idPersona);

    List<Reclamo> buscarReclamosConEstadoFalso();

    List<Reclamo> findReclamoByAdministrador_IdPersonaAndEstadoFalse(Long idPersona);

    void deleteByIdReclamo(Long idReclamo);

}
