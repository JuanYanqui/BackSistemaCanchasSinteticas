package com.sistema.canchas.service;

import com.sistema.canchas.model.Reserva;
import com.sistema.canchas.repository.ReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservaServiceImpl extends GenericServiceImpl<Reserva,Long>implements ReservaService{
    @Autowired
    ReservaRepository reservaRepository;
    @Override
    public CrudRepository<Reserva, Long> getDao() {
        return reservaRepository;
    }
}
