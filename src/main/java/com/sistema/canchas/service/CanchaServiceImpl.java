package com.sistema.canchas.service;

import com.sistema.canchas.model.Cancha;
import com.sistema.canchas.model.Establecimiento;
import com.sistema.canchas.repository.CanchaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CanchaServiceImpl extends GenericServiceImpl<Cancha,Long>implements CanchaService{
    @Autowired
    CanchaRepository canchaRepository;
    @Override
    public CrudRepository<Cancha, Long> getDao() {
        return canchaRepository;
    }

    @Override
    public List<Cancha> listaByEstablecimeinto(Long idEstablecimiento) {

        return canchaRepository.findByEstablecimientoIdEstablecimiento(idEstablecimiento);
    }

    @Override
    public Optional<Cancha> porId(Long idCancha) {

        return canchaRepository.findById(idCancha);
    }
}
