package com.sistema.canchas.controller;

import com.sistema.canchas.model.Cancha;
import com.sistema.canchas.model.Establecimiento;
import com.sistema.canchas.model.Persona;
import com.sistema.canchas.model.Usuario;
import com.sistema.canchas.service.EstablecimientoService;
import com.sistema.canchas.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/establecimiento")
@CrossOrigin("*")
public class EstablecimientoController {
    @Autowired
    EstablecimientoService establecimientoService;

    @PostMapping("/cre")
    public ResponseEntity<Establecimiento> crearcli(@RequestBody Establecimiento establecimiento){
        return new ResponseEntity<>(establecimientoService.save(establecimiento), HttpStatus.CREATED);
    }
    @GetMapping("/li")
    public ResponseEntity<List<Establecimiento>> getList(){
        return new ResponseEntity<>(establecimientoService.findByAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{idEstablecimiento}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Optional<Establecimiento> porId(@PathVariable Long idEstablecimiento){
        return establecimientoService.porId(idEstablecimiento);
    }

    @PutMapping("/upd/{id}")
    public ResponseEntity<Establecimiento> UpdateUser(@RequestBody Establecimiento e,@PathVariable Long id){
        Establecimiento es = establecimientoService.findById(id);
        es.setNombre(e.getNombre());
        es.setHoraCierre(e.getHoraCierre());
        es.setHoraApertura(e.getHoraApertura());
        es.setBar(e.getBar());
        es.setBanios(e.getBanios());
        es.setVestidores(e.getVestidores());
        es.setEstacionamiento(e.getEstacionamiento());
        es.setFotoestablecimiento(e.getFotoestablecimiento());
        return new ResponseEntity<>(establecimientoService.save(es),HttpStatus.CREATED);

    }

    @RequestMapping(value = "byRuc/{ruc}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Establecimiento porCedula(@PathVariable String ruc){
        return establecimientoService.Ruc(ruc);
    }

    @DeleteMapping("/eli/{id}")
    public ResponseEntity <?> eliminarli(@PathVariable Long id) {
        establecimientoService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/listbypersona/{idPersona}", method = RequestMethod.GET)
    public List<Establecimiento> getEstablecimientos(@PathVariable Long idPersona){
        return establecimientoService.listarByPersona(idPersona);
    }

    @Autowired
    PersonaService personaService;

    @GetMapping("/lip/{id}")
    public ResponseEntity<List<Establecimiento>> getList(@PathVariable Long id){
        Persona p=personaService.findById(id);
        return new ResponseEntity<>(establecimientoService.findByPersona(p),HttpStatus.OK);
    }

}
