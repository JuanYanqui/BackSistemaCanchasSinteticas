package com.sistema.canchas.controller;

import com.sistema.canchas.model.FotoEstablecimiento;
import com.sistema.canchas.service.FotoEstablecimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fotoEstablecimiento")
public class FotoEstablecimientoController {
    @Autowired
    FotoEstablecimientoService fotoEstablecimientoService;
    @GetMapping("/li")
    public ResponseEntity<List<FotoEstablecimiento>>getList(){
        return new ResponseEntity<>(fotoEstablecimientoService.findByAll(), HttpStatus.OK);
    }
}
