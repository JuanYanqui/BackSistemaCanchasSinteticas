package com.sistema.canchas.service;

import com.sistema.canchas.model.Cancha;
import com.sistema.canchas.model.Disponibilidad;
import com.sistema.canchas.repository.DisponibilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DisponibilidadServiceImpl extends GenericServiceImpl<Disponibilidad,Long> implements DisponibilidadService{
    @Autowired
    DisponibilidadRepository disponibilidadRepository;
    @Override
    public CrudRepository<Disponibilidad, Long> getDao() {
        return disponibilidadRepository;
    }

    @Override
    public Optional<Disponibilidad> porId(Long idDisponibilidad) {

        return disponibilidadRepository.findById(idDisponibilidad);
    }
}
