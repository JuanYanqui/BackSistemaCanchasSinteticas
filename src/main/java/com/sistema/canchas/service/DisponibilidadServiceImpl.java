package com.sistema.canchas.service;

import com.sistema.canchas.model.Disponibilidad;
import com.sistema.canchas.repository.DisponibilidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class DisponibilidadServiceImpl extends GenericServiceImpl<Disponibilidad,Long> implements DisponibilidadService{
    @Autowired
    DisponibilidadRepository disponibilidadRepository;
    @Override
    public CrudRepository<Disponibilidad, Long> getDao() {
        return disponibilidadRepository;
    }
}
