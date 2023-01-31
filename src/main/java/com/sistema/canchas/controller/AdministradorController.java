package com.sistema.canchas.controller;

import com.sistema.canchas.model.Administrador;
import com.sistema.canchas.service.AdministradorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/administrador")
public class AdministradorController {
    @Autowired
    AdministradorService administradorService;

    @GetMapping("/li")
    public ResponseEntity<List<Administrador>> getList(){
        return new ResponseEntity<>(administradorService.findByAll(), HttpStatus.OK);
    }
    @PostMapping("/cr")
    public ResponseEntity<Administrador> createAdmin(@RequestBody Administrador administrador){
        return new ResponseEntity<>(administradorService.save(administrador),HttpStatus.CREATED);
    }
    @PutMapping("/up/{id}")
    public ResponseEntity<Administrador>updateAdmin(@RequestBody Administrador administrador,@PathVariable Long id){
        Administrador a=administradorService.findById(id);
        a.setEntidad_bancaria(administrador.getEntidad_bancaria());
        a.setN_cuenta_bancaria(administrador.getN_cuenta_bancaria());
        return new ResponseEntity<>(administradorService.save(a),HttpStatus.CREATED);
    }
    @DeleteMapping("/dl/{id}")
    public ResponseEntity<?>deleteAdmin(@PathVariable Long id){
        administradorService.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


}
