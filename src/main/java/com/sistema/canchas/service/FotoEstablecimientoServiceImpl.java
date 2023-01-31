package com.sistema.canchas.service;

import com.sistema.canchas.model.FotoEstablecimiento;
import com.sistema.canchas.repository.FotoEstablecimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class FotoEstablecimientoServiceImpl extends GenericServiceImpl<FotoEstablecimiento,Long>implements FotoEstablecimientoService{
    @Autowired
    FotoEstablecimientoRepository fotoEstablecimientoRepository;


    @Override
    public CrudRepository<FotoEstablecimiento, Long> getDao() {
        return fotoEstablecimientoRepository;
    }
}
