package com.sistema.canchas.controller;

import com.sistema.canchas.model.Cliente;
import com.sistema.canchas.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    ClienteService clienteService;

    @GetMapping("/li")
    public ResponseEntity<List<Cliente>>getList(){
        return new ResponseEntity<>(clienteService.findByAll(), HttpStatus.OK);
    }
}
