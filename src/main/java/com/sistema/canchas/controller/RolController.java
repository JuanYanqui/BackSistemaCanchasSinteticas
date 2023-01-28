package com.sistema.canchas.controller;

import com.sistema.canchas.model.Rol;
import com.sistema.canchas.model.Usuario;
import com.sistema.canchas.service.RolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rol")
@CrossOrigin("*")
public class RolController {
    @Autowired
    private RolService rolService;


    @RequestMapping(value = "/{idRol}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Optional<Rol> porId(@PathVariable Long idRol){
        return rolService.porId(idRol);
    }
    @GetMapping("/li")
    public ResponseEntity<List<Rol>> obtenerListali() {
        return new ResponseEntity<>(rolService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/cre")
    public ResponseEntity<Rol> crearcli(@RequestBody Rol rol){
        return new ResponseEntity<>(rolService.save(rol), HttpStatus.CREATED);
    }

    @DeleteMapping("/eli/{id}")
    public ResponseEntity <?> eliminarli(@PathVariable Long id) {
        rolService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "byName/{nombre}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Rol porNombre(@PathVariable String nombre){
        return rolService.porNombre(nombre);
    }
}
