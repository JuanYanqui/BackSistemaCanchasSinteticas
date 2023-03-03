package com.sistema.canchas.repository;

import com.sistema.canchas.model.Reclamo;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.canchas.model.Reclamo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReclamoRepository extends JpaRepository<Reclamo,Long> {

    List<Reclamo> findReclamoByAdministrador_IdPersona(Long idPersona);

    List<Reclamo> findReclamoByCliente_IdPersona(Long idPersona);

    List<Reclamo> findByEstadoFalse();

    List<Reclamo> findReclamoByAdministrador_IdPersonaAndEstadoFalse(Long idPersona);

    void deleteByIdReclamo(Long idReclamo);

}