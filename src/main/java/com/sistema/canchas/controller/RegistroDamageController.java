package com.sistema.canchas.controller;

import com.sistema.canchas.model.RegistroDamage;
import com.sistema.canchas.service.RegistroDamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/registroDamage")
@CrossOrigin("*")
public class RegistroDamageController {
    @Autowired
    RegistroDamageService registroDamageService;
    @GetMapping("/li")
    public ResponseEntity<List<RegistroDamage>>getList(){
        return new ResponseEntity<>(registroDamageService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/cr")
    public ResponseEntity<RegistroDamage>crear(@RequestBody RegistroDamage rd){
        return  new ResponseEntity<>(registroDamageService.save(rd),HttpStatus.CREATED);
    }
    @PutMapping("/up/{id}")
    public ResponseEntity<RegistroDamage>update(@RequestBody RegistroDamage r, @PathVariable Long id){
        RegistroDamage rd=registroDamageService.findById(id);
        rd.setFoto(r.getFoto());
        rd.setDescripcion(r.getDescripcion());
        rd.setValor(r.getValor());
        return new ResponseEntity<>(registroDamageService.save(rd),HttpStatus.CREATED);
    }
}
