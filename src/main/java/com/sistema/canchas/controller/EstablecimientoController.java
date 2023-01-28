package com.sistema.canchas.controller;

import com.sistema.canchas.model.Establecimiento;
import com.sistema.canchas.model.Rol;
import com.sistema.canchas.service.EstablecimientoService;
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
    @Autowired(required = true)
    private EstablecimientoService serviceestablecimiento;

    @GetMapping("/li")
    public ResponseEntity<List<Establecimiento>> obtenerListali() {
        return new ResponseEntity<>(serviceestablecimiento.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/cre")
    public ResponseEntity<Establecimiento> crearcli(@RequestBody Establecimiento establecimiento){
        return new ResponseEntity<>(serviceestablecimiento.save(establecimiento), HttpStatus.CREATED);
    }

    @DeleteMapping("/eli/{id}")
    public ResponseEntity <?> eliminarli(@PathVariable Long id) {
        serviceestablecimiento.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{idEmpresa}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Optional<Establecimiento> porId(@PathVariable Long idEstablecimiento){
        return serviceestablecimiento.porId(idEstablecimiento);
    }



    @RequestMapping(value = "/porPersona/{idPersona}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Establecimiento porIdPersona(@PathVariable Long idPersona){
        return serviceestablecimiento.porIdPersona(idPersona);
    }

    @RequestMapping(value = "porRuc/{ruc}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public boolean porRuc(@PathVariable String ruc){
        return serviceestablecimiento.porRuc(ruc);
    }
}
