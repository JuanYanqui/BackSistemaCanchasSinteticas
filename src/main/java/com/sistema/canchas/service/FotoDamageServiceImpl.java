package com.sistema.canchas.service;

import com.sistema.canchas.model.FotoDamage;
import com.sistema.canchas.repository.FotoDamageRepository;
import com.sistema.canchas.repository.FotoEstablecimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class FotoDamageServiceImpl extends GenericServiceImpl<FotoDamage,Long>implements FotoDamageService{
    @Autowired
    FotoDamageRepository fotoDamageRepository;

    @Override
    public CrudRepository<FotoDamage, Long> getDao() {
        return fotoDamageRepository;
    }
}
