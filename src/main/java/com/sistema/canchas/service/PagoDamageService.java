package com.sistema.canchas.service;

import com.sistema.canchas.model.PagoDamage;
import com.sistema.canchas.model.RegistroDamage;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface PagoDamageService extends GenericService<PagoDamage,Long>{
    PagoDamage findByRegistroDamage(RegistroDamage registroDamage);

    List<PagoDamage> findByIdP(@Param("personaId") Long personaId);


}
