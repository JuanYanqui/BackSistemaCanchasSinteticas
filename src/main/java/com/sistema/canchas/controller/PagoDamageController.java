package com.sistema.canchas.controller;

import com.sistema.canchas.model.PagoDamage;
import com.sistema.canchas.model.RegistroDamage;
import com.sistema.canchas.service.PagoDamageService;
import com.sistema.canchas.service.RegistroDamageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagoDamage")
@CrossOrigin("*")
public class PagoDamageController {
    @Autowired
    PagoDamageService pagoDamageService;
    @GetMapping("/li")
    public ResponseEntity<List<PagoDamage>>getList(){
        return new ResponseEntity<>(pagoDamageService.findByAll(), HttpStatus.OK);
    }

    @Autowired
    RegistroDamageService registroDamageService;

    @GetMapping("/lir/{id}")
    public ResponseEntity<PagoDamage>getListR(@PathVariable Long id){
        RegistroDamage r=registroDamageService.findById(id);
        return new ResponseEntity<>(pagoDamageService.findByRegistroDamage(r),HttpStatus.OK);
    }

    @GetMapping("/lipd/{personaId}")
    public ResponseEntity<List<PagoDamage>> getListPd(@PathVariable Long personaId){
        return new ResponseEntity<>(pagoDamageService.findByIdP(personaId),HttpStatus.OK);
    }

    @PostMapping("/cr")
    public ResponseEntity<PagoDamage>crear(@RequestBody PagoDamage pagoDamage){
        return new ResponseEntity<>(pagoDamageService.save(pagoDamage),HttpStatus.CREATED);
    }

    @PutMapping("/up/{id}")
    public ResponseEntity<PagoDamage>update(@RequestBody PagoDamage pago,@PathVariable Long id){
        PagoDamage p=pagoDamageService.findById(id);
        p.setFoto(pago.getFoto());
        p.setFecha_pago(pago.getFecha_pago());
        p.setEstado(pago.getEstado());
        return new ResponseEntity<>(pagoDamageService.save(p),HttpStatus.CREATED);
    }
}
