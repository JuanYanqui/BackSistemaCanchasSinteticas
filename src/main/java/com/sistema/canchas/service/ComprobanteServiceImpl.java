package com.sistema.canchas.service;

import com.sistema.canchas.model.Comprobante;
import com.sistema.canchas.repository.ComprobanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ComprobanteServiceImpl extends GenericServiceImpl<Comprobante,Long>implements ComprobanteService{
    @Autowired
    ComprobanteRepository comprobanteRepository;
    @Override
    public CrudRepository<Comprobante, Long> getDao() {
        return comprobanteRepository;
    }
}
