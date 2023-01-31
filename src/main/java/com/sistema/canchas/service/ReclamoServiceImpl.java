package com.sistema.canchas.service;

import com.sistema.canchas.model.Reclamo;
import com.sistema.canchas.repository.ReclamoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ReclamoServiceImpl extends GenericServiceImpl<Reclamo,Long>implements ReclamoService{
    @Autowired
    ReclamoRepository reclamoRepository;

    @Override
    public CrudRepository<Reclamo, Long> getDao() {
        return reclamoRepository;
    }
}
