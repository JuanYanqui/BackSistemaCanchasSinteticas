package com.sistema.canchas.repository;

import com.sistema.canchas.model.Establecimiento;
import com.sistema.canchas.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EstablecimientoRepository extends JpaRepository<Establecimiento, Long> {

        Establecimiento findByRuc(String ruc);

        List<Establecimiento> findByPersonaIdPersona(Long idPersona);

        List<Establecimiento> findByPersona(Persona persona);

}
