package com.sistema.canchas.service;

import com.sistema.canchas.model.Blacklist;
import com.sistema.canchas.repository.BlacklistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class BlacklistServiceImpl extends GenericServiceImpl<Blacklist,Long> implements BlacklistService {
    @Autowired
    BlacklistRepository blacklistRepository;

    @Override
    public CrudRepository<Blacklist, Long> getDao() {
        return blacklistRepository;
    }
}
