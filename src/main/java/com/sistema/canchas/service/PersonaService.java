package com.sistema.canchas.service;

import com.sistema.canchas.model.Establecimiento;
import com.sistema.canchas.model.Persona;

import java.util.List;
import java.util.Optional;

public interface PersonaService extends GenericService <Persona, Long>{
    Persona porCedula(String cedula);
    Optional<Persona> porId(Long idPersona);

 /*   List<Establecimiento> listaByEstable(Long idPersona);
*/
}
