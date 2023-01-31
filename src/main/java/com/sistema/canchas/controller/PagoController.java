package com.sistema.canchas.controller;

import com.sistema.canchas.model.Pago;
import com.sistema.canchas.service.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pago")
public class PagoController {
    @Autowired
    PagoService pagoService;
    @GetMapping("/li")
    public ResponseEntity<List<Pago>>getList(){
        return new ResponseEntity<>(pagoService.findByAll(), HttpStatus.OK);
    }
}
