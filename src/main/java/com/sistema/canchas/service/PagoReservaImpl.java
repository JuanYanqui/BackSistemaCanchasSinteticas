package com.sistema.canchas.service;

import com.sistema.canchas.model.PagoReserva;
import com.sistema.canchas.repository.PagoReservaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PagoReservaImpl extends GenericServiceImpl<PagoReserva,Long> implements PagoReservaService{
    @Autowired
    PagoReservaRepository pagoReservaRepository;

    @Override
    public CrudRepository<PagoReserva, Long> getDao() {
        return pagoReservaRepository;
    }
}
