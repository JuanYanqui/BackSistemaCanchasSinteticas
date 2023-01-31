package com.sistema.canchas.controller;

import com.sistema.canchas.model.Establecimiento;
import com.sistema.canchas.service.EstablecimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/establecimiento")
public class EstablecimientoController {
    @Autowired
    EstablecimientoService establecimientoService;
    @GetMapping("/li")
    public ResponseEntity<List<Establecimiento>> getList(){
        return new ResponseEntity<>(establecimientoService.findByAll(), HttpStatus.OK);
    }

}
