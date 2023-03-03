package com.sistema.canchas.controller;

import com.sistema.canchas.model.Reclamo;
import com.sistema.canchas.service.ReclamoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.sistema.canchas.model.Reclamo;
import com.sistema.canchas.service.ReclamoService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import com.sistema.canchas.model.Reclamo;
import com.sistema.canchas.service.ReclamoService;
import jakarta.transaction.Transactional;
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
    public ResponseEntity<Reclamo> crearReclamo(@RequestBody Reclamo reclamo){
        return new ResponseEntity<>(reclamoService.save(reclamo), HttpStatus.CREATED);
    }
    @PutMapping("/upd/{id}")
    public ResponseEntity<Reclamo> UpdateReclamo(@RequestBody Reclamo r,@PathVariable Long id){
        Reclamo rec=reclamoService.findById(id);
        rec.setTitulo(r.getTitulo());
        rec.setDescripcion(r.getDescripcion());
        rec.setEstado(r.getEstado());
        return new ResponseEntity<>(reclamoService.save(rec),HttpStatus.CREATED);

    }

    @RequestMapping(value = "/{idPersona}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Optional<Reclamo> porId(@PathVariable Long idPersona){
        return reclamoService.porId(idPersona);
    }

    @RequestMapping(value = "/listbyadmin/{idPersona}", method = RequestMethod.GET)
    public List<Reclamo> getReclamos(@PathVariable Long idPersona){
        return reclamoService.listarByReclamos(idPersona);
    }

    @RequestMapping(value = "/listbyclient/{idPersona}", method = RequestMethod.GET)
    public List<Reclamo> getReclamosCli(@PathVariable Long idPersona){
        return reclamoService.listarByReclamosCliente(idPersona);
    }

    @GetMapping("/estadoF")
    public List<Reclamo> getReclamosConEstadoFalso() {
        return reclamoService.buscarReclamosConEstadoFalso();
    }


    @GetMapping("/administrador/{idPersona}/estadoF")
    public List<Reclamo> findReclamoByAdministrador_IdPersonaAndEstadoFalse(@PathVariable Long idPersona) {
        return reclamoService.findReclamoByAdministrador_IdPersonaAndEstadoFalse(idPersona);
    }

    @DeleteMapping("/delete/{id}")
    @Transactional
    public ResponseEntity<?> deleteByIdReclamo(@PathVariable Long id) {
        reclamoService.deleteByIdReclamo(id);
        return ResponseEntity.ok().build();
    }
}