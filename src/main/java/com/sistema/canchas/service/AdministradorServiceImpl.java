package com.sistema.canchas.service;

import com.sistema.canchas.model.Administrador;
import com.sistema.canchas.repository.AdministradorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class AdministradorServiceImpl extends GenericServiceImpl<Administrador,Long>implements AdministradorService{
    @Autowired
    AdministradorRepository administradorRepository;
    @Override
    public CrudRepository<Administrador, Long> getDao() {
        return administradorRepository;
    }
}
