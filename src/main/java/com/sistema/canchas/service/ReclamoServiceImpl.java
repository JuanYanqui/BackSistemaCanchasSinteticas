package com.sistema.canchas.service;

import com.sistema.canchas.model.Reclamo;
import com.sistema.canchas.repository.ReclamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.sistema.canchas.model.Reclamo;
import com.sistema.canchas.repository.ReclamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReclamoServiceImpl extends GenericServiceImpl<Reclamo,Long>implements ReclamoService{
    @Autowired
    ReclamoRepository reclamoRepository;

    @Override
    public CrudRepository<Reclamo, Long> getDao() {
        return reclamoRepository;
    }

    @Override
    public Optional<Reclamo> porId(Long idReclamo) {

        return reclamoRepository.findById(idReclamo);
    }

    @Override
    public List<Reclamo> listarByReclamos(Long idPersona) {

        return reclamoRepository.findReclamoByAdministrador_IdPersona(idPersona);
    }

    @Override
    public List<Reclamo> listarByReclamosCliente(Long idPersona) {

        return reclamoRepository.findReclamoByCliente_IdPersona(idPersona);
    }

    @Override
    public List<Reclamo> buscarReclamosConEstadoFalso() {
        return reclamoRepository.findByEstadoFalse();
    }

    @Override
    public List<Reclamo> findReclamoByAdministrador_IdPersonaAndEstadoFalse(Long idPersona) {
        return reclamoRepository.findReclamoByAdministrador_IdPersonaAndEstadoFalse(idPersona);
    }

    @Override
    public void deleteByIdReclamo(Long idReclamo) {
        reclamoRepository.deleteByIdReclamo(idReclamo);
    }
}
