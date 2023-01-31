package com.sistema.canchas.service;

import com.sistema.canchas.model.Ubicacion;
import com.sistema.canchas.repository.UbicacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class UbicacionServiceImpl extends GenericServiceImpl<Ubicacion,Long> implements UbicacionService{
    @Autowired
    UbicacionRepository ubicacionRepository;
    @Override
    public CrudRepository<Ubicacion, Long> getDao() {
        return ubicacionRepository;
    }
}
