package com.sistema.canchas.controller;

import com.sistema.canchas.model.Ubicacion;
import com.sistema.canchas.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ubicacion")
public class UbicacionController {
    @Autowired
    UbicacionService ubicacionService;
    @GetMapping("/li")
    public ResponseEntity<List<Ubicacion>>getList(){
        return new ResponseEntity<>(ubicacionService.findByAll(), HttpStatus.OK);
    }
}
