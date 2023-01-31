package com.sistema.canchas.controller;

import com.sistema.canchas.model.Cancha;
import com.sistema.canchas.service.CanchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cancha")
public class CanchaController {
    @Autowired
    CanchaService canchaService;
    @GetMapping("/li")
    public ResponseEntity<List<Cancha>>getList(){
        return new ResponseEntity<>(canchaService.findByAll(), HttpStatus.OK);
    }
}
