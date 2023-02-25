package com.sistema.canchas.controller;

import com.sistema.canchas.model.Reclamo;
import com.sistema.canchas.service.ReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reclamo")
@CrossOrigin("*")
public class ReclamoController {
    @Autowired
    ReclamoService reclamoService;
    @GetMapping("/li")
    public ResponseEntity<List<Reclamo>>getList(){
        return new ResponseEntity<>(reclamoService.findByAll(), HttpStatus.OK);
    }
    @PostMapping("/cre")
    public ResponseEntity<Reclamo> crearcli(@RequestBody Reclamo reclamo){
        return new ResponseEntity<>(reclamoService.save(reclamo), HttpStatus.CREATED);
    }
    @PutMapping("/upd/{id}")
    public ResponseEntity<Reclamo> UpdateUser(@RequestBody Reclamo r,@PathVariable Long id){
        Reclamo rec=reclamoService.findById(id);
        rec.setTitulo(r.getTitulo());
        rec.setDescripcion(r.getDescripcion());
        //rec.setFecha_reclamo(r.getFecha_reclamo());
        return new ResponseEntity<>(reclamoService.save(rec),HttpStatus.CREATED);

    }

    @RequestMapping(value = "/{idPersona}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Optional<Reclamo> porId(@PathVariable Long idPersona){
        return reclamoService.porId(idPersona);
    }
}
