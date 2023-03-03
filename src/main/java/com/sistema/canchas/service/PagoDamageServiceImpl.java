package com.sistema.canchas.service;

import com.sistema.canchas.model.PagoDamage;
import com.sistema.canchas.model.RegistroDamage;
import com.sistema.canchas.repository.PagoDamageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PagoDamageServiceImpl extends GenericServiceImpl<PagoDamage,Long>implements PagoDamageService {
    @Autowired
    PagoDamageRepository pagoDamageRepository;
    @Override
    public CrudRepository<PagoDamage, Long> getDao() {
        return pagoDamageRepository;
    }

    @Override
    public PagoDamage findByRegistroDamage(RegistroDamage registroDamage) {
        return pagoDamageRepository.findByRegistroDamage(registroDamage);
    }

    @Override
    public List<PagoDamage> findByIdP(Long personaId) {
        return pagoDamageRepository.findByIdP(personaId);
    }

}
