package com.sistema.canchas.service;

import com.sistema.canchas.model.Establecimiento;
import com.sistema.canchas.model.Rol;
import com.sistema.canchas.repository.EstablecimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EstablecimientoServiceImpl extends GenericServiceImpl<Establecimiento, Long> implements EstablecimientoService{
    @Autowired
    EstablecimientoRepository establecimientoRepository;

    @Override
    public CrudRepository<Establecimiento, Long> getDao() {
        return establecimientoRepository;
    }

    @Override
    public Optional<Establecimiento> porId(Long idEstablecimiento) {

        return establecimientoRepository.findById(idEstablecimiento);
    }

    @Override
    public Establecimiento porIdPersona(Long idPersona) {

        return establecimientoRepository.findByPersonaIdPersona(idPersona);
    }
    @Override
    public boolean porRuc(String ruc) {
        if (establecimientoRepository.findByRuc(ruc)!=null) {
            return true;
        }else {
            return false;
        }

    }
}
