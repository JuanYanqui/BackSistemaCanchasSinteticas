package com.sistema.canchas.controller;

import com.sistema.canchas.model.Comprobante;
import com.sistema.canchas.service.ComprobanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/comprobante")
public class ComprobanteController {
    @Autowired
    ComprobanteService comprobanteService;
    @GetMapping("/li")
    public ResponseEntity<List<Comprobante>>getList(){
        return new ResponseEntity<>(comprobanteService.findByAll(), HttpStatus.OK);
    }
}
