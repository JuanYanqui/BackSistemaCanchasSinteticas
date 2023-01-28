package com.sistema.canchas.repository;

import com.sistema.canchas.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Persona findByCedula(String cedula);
}
