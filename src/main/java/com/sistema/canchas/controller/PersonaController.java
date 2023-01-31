package com.sistema.canchas.controller;

import com.sistema.canchas.model.Persona;
import com.sistema.canchas.model.Rol;
import com.sistema.canchas.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
@CrossOrigin("*")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping("/li")
    public ResponseEntity<List<Persona>> obtenerListali() {
        return new ResponseEntity<>(personaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/cre")
    public ResponseEntity<Persona> crearcli(@RequestBody Persona persona){
        return new ResponseEntity<>(personaService.save(persona), HttpStatus.CREATED);
    }

    @PutMapping("/upd/{ced}")
    public ResponseEntity<Persona> upddatePersona(@RequestBody Persona p,@PathVariable String ced){
        Persona pe=personaService.porCedula(ced);
        pe.setNombres(p.getNombres());
        pe.setApellidos(p.getApellidos());
        pe.setFechaNacimmiento(p.getFechaNacimmiento());
        pe.setGenero(p.getGenero());
        pe.setDireccion(p.getDireccion());
        pe.setEmail(p.getEmail());
        pe.setTelefono(p.getTelefono());
        pe.setCelular(p.getCelular());
        pe.setFoto(p.getFoto());
        return new ResponseEntity<>(personaService.save(pe),HttpStatus.CREATED);
    }

    @DeleteMapping("/eli/{id}")
    public ResponseEntity <?> eliminarli(@PathVariable Long id) {
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{idPersona}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Optional<Persona> porId(@PathVariable Long idPersona){
        return personaService.porId(idPersona);
    }


    @RequestMapping(value = "byCedula/{cedula}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Persona porCedula(@PathVariable String cedula){
        return personaService.porCedula(cedula);
    }


}
