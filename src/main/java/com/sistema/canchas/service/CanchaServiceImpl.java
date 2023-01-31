package com.sistema.canchas.service;

import com.sistema.canchas.model.Cancha;
import com.sistema.canchas.repository.CanchaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class CanchaServiceImpl extends GenericServiceImpl<Cancha,Long>implements CanchaService{
    @Autowired
    CanchaRepository canchaRepository;
    @Override
    public CrudRepository<Cancha, Long> getDao() {
        return canchaRepository;
    }
}
