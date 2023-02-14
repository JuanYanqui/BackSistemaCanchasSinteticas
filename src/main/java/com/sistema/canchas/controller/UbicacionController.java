package com.sistema.canchas.controller;

import com.sistema.canchas.model.Ubicacion;
import com.sistema.canchas.service.UbicacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ubicacion")
@CrossOrigin("*")
public class UbicacionController {
    @Autowired
    UbicacionService ubicacionService;
    @PostMapping("/cre")
    public ResponseEntity<Ubicacion> crearcli(@RequestBody Ubicacion ubicacion){
        return new ResponseEntity<>(ubicacionService.save(ubicacion), HttpStatus.CREATED);
    }
    @GetMapping("/li")
    public ResponseEntity<List<Ubicacion>>getList(){
        return new ResponseEntity<>(ubicacionService.findByAll(), HttpStatus.OK);
    }

    @PutMapping("/upd/{id}")
    public ResponseEntity<Ubicacion> UpdateUser(@RequestBody Ubicacion u,@PathVariable Long id){
        Ubicacion ub = ubicacionService.findById(id);
        ub.setCalle_principal(u.getCalle_principal());
        ub.setCalle_secundaria(u.getCalle_secundaria());
        ub.setNumero(u.getNumero());
        ub.setReferencia(u.getReferencia());
        ub.setLatitud(u.getLatitud());
        ub.setLongitud(u.getLongitud());
        return new ResponseEntity<>(ubicacionService.save(ub),HttpStatus.CREATED);

    }
}
