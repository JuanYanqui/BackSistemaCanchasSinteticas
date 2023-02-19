package com.sistema.canchas.repository;

import com.sistema.canchas.model.Establecimiento;
import com.sistema.canchas.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PersonaRepository extends JpaRepository<Persona, Long> {
    Persona findByCedula(String cedula);

   /* List<Establecimiento> findBidPersona(Long idPersona);*/


}
