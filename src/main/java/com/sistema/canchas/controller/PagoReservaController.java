package com.sistema.canchas.controller;

import com.sistema.canchas.model.PagoReserva;
import com.sistema.canchas.service.PagoReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pago")
public class PagoReservaController {
    @Autowired
    PagoReservaService pagoReservaService;
    @GetMapping("/li")
    public ResponseEntity<List<PagoReserva>> getList(){
        return new ResponseEntity<>(pagoReservaService.findByAll(), HttpStatus.OK);
    }
}
