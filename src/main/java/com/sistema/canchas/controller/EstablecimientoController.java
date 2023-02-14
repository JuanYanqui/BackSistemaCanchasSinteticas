package com.sistema.canchas.controller;

import com.sistema.canchas.model.Establecimiento;
import com.sistema.canchas.model.Usuario;
import com.sistema.canchas.service.EstablecimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
        return new ResponseEntity<>(establecimientoService.save(es),HttpStatus.CREATED);

    }

}
