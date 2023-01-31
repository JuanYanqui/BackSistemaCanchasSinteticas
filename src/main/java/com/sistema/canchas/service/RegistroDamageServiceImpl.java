package com.sistema.canchas.service;

import com.sistema.canchas.model.RegistroDamage;
import com.sistema.canchas.repository.RegistroDamageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistroDamageServiceImpl extends GenericServiceImpl<RegistroDamage,Long>implements RegistroDamageService{
    @Autowired
    RegistroDamageRepository registroDamageRepository;
    @Override
    public CrudRepository<RegistroDamage, Long> getDao() {
        return registroDamageRepository;
    }
}
