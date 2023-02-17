package com.sistema.canchas.controller;

import com.sistema.canchas.model.Disponibilidad;
import com.sistema.canchas.service.DisponibilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disponibilidad")
public class DisponibilidadController {
    @Autowired
    DisponibilidadService disponibilidadService;
    @GetMapping("/li")
    public ResponseEntity<List<Disponibilidad>>getList(){
        return new ResponseEntity<>(disponibilidadService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/cre")
    public ResponseEntity<Disponibilidad> crearcancha(@RequestBody Disponibilidad disponibilidad){
        return new ResponseEntity<>(disponibilidadService.save(disponibilidad), HttpStatus.CREATED);
    }
}
