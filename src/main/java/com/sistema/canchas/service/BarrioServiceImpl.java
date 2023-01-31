package com.sistema.canchas.service;

import com.sistema.canchas.model.Barrio;
import com.sistema.canchas.repository.BarrioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class BarrioServiceImpl extends GenericServiceImpl<Barrio,Long>implements BarrioService{
    @Autowired
    BarrioRepository barrioRepository;
    @Override
    public CrudRepository<Barrio, Long> getDao() {
        return barrioRepository;
    }
}
