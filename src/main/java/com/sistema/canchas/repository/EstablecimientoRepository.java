package com.sistema.canchas.repository;

import com.sistema.canchas.model.Establecimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstablecimientoRepository extends JpaRepository<Establecimiento, Long> {
    Establecimiento findByPersonaIdPersona(Long idPersona);

    Establecimiento findByRuc(String ruc);
}
