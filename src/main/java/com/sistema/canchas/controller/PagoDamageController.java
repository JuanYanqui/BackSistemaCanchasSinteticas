package com.sistema.canchas.controller;

import com.sistema.canchas.model.PagoDamage;
import com.sistema.canchas.service.PagoDamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pagoDamage")
public class PagoDamageController {
    @Autowired
    PagoDamageService pagoDamageService;
    @GetMapping("/li")
    public ResponseEntity<List<PagoDamage>>getList(){
        return new ResponseEntity<>(pagoDamageService.findByAll(), HttpStatus.OK);
    }
}
