package com.sistema.canchas.controller;

import com.sistema.canchas.model.Cancha;
import com.sistema.canchas.model.Usuario;
import com.sistema.canchas.service.CanchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cancha")
@CrossOrigin("*")
public class CanchaController {
    @Autowired
    private CanchaService canchaService;

    @GetMapping("/li")
    public ResponseEntity<List<Cancha>> obtenerListali() {
        return new ResponseEntity<>(canchaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/cre")
    public ResponseEntity<Cancha> crearcancha(@RequestBody Cancha cancha){
        return new ResponseEntity<>(canchaService.save(cancha), HttpStatus.CREATED);
    }

    @PutMapping("/upd/{id}")
    public ResponseEntity<Cancha> updateCancha(@RequestBody Cancha cancha,@PathVariable Long id){
        Cancha ca=canchaService.findById(id);
        ca.setNombre(cancha.getNombre());
        ca.setAncho(cancha.getAncho());
        ca.setAltura(cancha.getAltura());
        ca.setDescripcion(cancha.getDescripcion());
        ca.setTarifa(cancha.getTarifa());
        ca.setVacante(cancha.getVacante());
        ca.setFoto(cancha.getFoto());

        return new ResponseEntity<>(canchaService.save(ca),HttpStatus.CREATED);
    }

    @RequestMapping(value = "/listbyestablecimiento/{idEstablecimiento}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public List<Cancha> getProveedor(@PathVariable Long idEstablecimiento){
        return canchaService.listaByEstablecimeinto(idEstablecimiento);
    }

    @RequestMapping(value = "/{idCancha}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Optional<Cancha> porId(@PathVariable Long idCancha) {
        return canchaService.porId(idCancha);
    }
}
