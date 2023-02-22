package com.sistema.canchas.repository;

import com.sistema.canchas.model.PagoDamage;
import com.sistema.canchas.model.RegistroDamage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PagoDamageRepository extends JpaRepository<PagoDamage,Long> {
    PagoDamage findByRegistroDamage(RegistroDamage registroDamage);

    @Query("SELECT pd FROM PagoDamage pd WHERE pd.registroDamage.establecimiento.persona.idPersona=:personaId")
    List<PagoDamage> findByIdP(@Param("personaId") Long personaId);
}
