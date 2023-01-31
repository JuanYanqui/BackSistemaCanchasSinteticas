package com.sistema.canchas.controller;

import com.sistema.canchas.model.Reclamo;
import com.sistema.canchas.service.ReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reclamo")
public class ReclamoController {
    @Autowired
    ReclamoService reclamoService;
    @GetMapping("/li")
    public ResponseEntity<List<Reclamo>>getList(){
        return new ResponseEntity<>(reclamoService.findByAll(), HttpStatus.OK);
    }
}
