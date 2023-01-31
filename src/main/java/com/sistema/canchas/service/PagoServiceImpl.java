package com.sistema.canchas.service;

import com.sistema.canchas.model.Pago;
import com.sistema.canchas.repository.PagoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PagoServiceImpl extends GenericServiceImpl<Pago,Long>implements PagoService{
    @Autowired
    PagoRepository pagoRepository;
    @Override
    public CrudRepository<Pago, Long> getDao() {
        return pagoRepository;
    }
}
