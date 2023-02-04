package com.sistema.canchas.service;

import com.sistema.canchas.model.PagoDamage;
import com.sistema.canchas.repository.PagoDamageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class PagoDamageServiceImpl extends GenericServiceImpl<PagoDamage,Long>implements PagoDamageService {
    @Autowired
    PagoDamageRepository pagoDamageRepository;
    @Override
    public CrudRepository<PagoDamage, Long> getDao() {
        return pagoDamageRepository;
    }
}
