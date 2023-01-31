package com.sistema.canchas.controller;

import com.sistema.canchas.model.Barrio;
import com.sistema.canchas.service.BarrioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/barrio")
public class BarrioController {
    @Autowired
    BarrioService barrioService;
    @GetMapping("/li")
    public ResponseEntity<List<Barrio>>getList(){
        return new ResponseEntity<>(barrioService.findByAll(), HttpStatus.OK);
    }
}
