package com.sistema.canchas.service;

import com.sistema.canchas.model.Establecimiento;
import com.sistema.canchas.model.Persona;
import com.sistema.canchas.model.Rol;
import com.sistema.canchas.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Long> implements PersonaService{
    @Autowired
    PersonaRepository personaRepository;

    @Override
    public CrudRepository<Persona, Long> getDao() {
        return personaRepository;
    }

    @Override
    public Persona porCedula(String cedula) {

        return personaRepository.findByCedula(cedula);
    }

    @Override
    public Optional<Persona> porId(Long idPersona) {

        return personaRepository.findById(idPersona);
    }

  /*  @Override
    public List<Establecimiento> listaByEstable(Long idPersona) {

        return personaRepository.findBidPersona(idPersona);
    }*/
}
