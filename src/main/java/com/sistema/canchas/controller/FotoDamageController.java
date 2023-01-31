package com.sistema.canchas.controller;

import com.sistema.canchas.model.FotoDamage;
import com.sistema.canchas.service.FotoDamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fotoDamage")
public class FotoDamageController {
    @Autowired
    FotoDamageService fotoDamageService;
    @GetMapping("/li")
    public ResponseEntity<List<FotoDamage>>getList(){
        return new ResponseEntity<>(fotoDamageService.findByAll(), HttpStatus.OK);
    }
}
