package com.sistema.canchas.controller;

import com.sistema.canchas.model.RegistroDamage;
import com.sistema.canchas.service.RegistroDamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/registroDamage")
public class RegistroDamageController {
    @Autowired
    RegistroDamageService registroDamageService;
    @GetMapping("/li")
    public ResponseEntity<List<RegistroDamage>>getList(){
        return new ResponseEntity<>(registroDamageService.findByAll(), HttpStatus.OK);
    }
}
