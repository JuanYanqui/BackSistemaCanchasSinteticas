package com.sistema.canchas.controller;

import com.sistema.canchas.model.Cancha;
import com.sistema.canchas.model.Reserva;
import com.sistema.canchas.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reserva")
@CrossOrigin("*")
public class ReservaController {
    @Autowired
    ReservaService reservaService;
    @GetMapping("/li")
    public ResponseEntity<List<Reserva>>getList(){
        return new ResponseEntity<>(reservaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/cre")
    public ResponseEntity<Reserva> crear(@RequestBody Reserva reserva){
        return new ResponseEntity<>(reservaService.save(reserva), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public Reserva getUsuarioConPublicaciones(@PathVariable Long id) {
        return reservaService.obtenerUsuarioConPublicaciones(id);
    }

    @DeleteMapping("/eli/{id}")
    public ResponseEntity <?> eliminarli(@PathVariable Long id) {
        reservaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }



    @GetMapping("/cliente/{idPersona}")
    public List<Reserva> getReservasByClienteId(@PathVariable Long idPersona) {
        return reservaService.buscarPorIdCliente(idPersona);
    }
}
