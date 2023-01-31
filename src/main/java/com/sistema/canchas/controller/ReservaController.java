package com.sistema.canchas.controller;

import com.sistema.canchas.model.Reserva;
import com.sistema.canchas.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reserva")
public class ReservaController {
    @Autowired
    ReservaService reservaService;
    @GetMapping("/li")
    public ResponseEntity<List<Reserva>>getList(){
        return new ResponseEntity<>(reservaService.findByAll(), HttpStatus.OK);
    }
}
