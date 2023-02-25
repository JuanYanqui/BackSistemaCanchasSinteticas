package com.sistema.canchas.controller;

import com.sistema.canchas.model.Cancha;
import com.sistema.canchas.model.Disponibilidad;
import com.sistema.canchas.service.DisponibilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disponibilidad")
@CrossOrigin("*")
public class DisponibilidadController {
    @Autowired
    DisponibilidadService disponibilidadService;

    @GetMapping("/li")
    public ResponseEntity<List<Disponibilidad>>getList(){
        return new ResponseEntity<>(disponibilidadService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/cre")
    public ResponseEntity<Disponibilidad> crearcancha(@RequestBody Disponibilidad disponibilidad){

        return new ResponseEntity<>(disponibilidadService.save(disponibilidad), HttpStatus.CREATED);
    }

    @DeleteMapping("/eli/{id}")
    public ResponseEntity <?> eliminarli(@PathVariable Long id) {
        disponibilidadService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{idDisponibilidad}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Optional<Disponibilidad> porId(@PathVariable Long idCancha) {
        return disponibilidadService.porId(idCancha);
    }

   /* @GetMapping("/disponibilidades")
    public List<Disponibilidad> getDisponibilidadesPorFechaYHora(@RequestParam("fecha") Date fecha,
                                                                 @RequestParam("hora") Integer hora,
                                                                 @RequestParam("idCancha") Long idCancha) {
        return disponibilidadService.getDisponibilidadesPorFechaYHora(fecha, hora, idCancha);
    }*/

    @GetMapping("/disponibilidades")
    public List<Disponibilidad> getDisponibilidadesPorFechaYHora(@RequestParam("fecha") @DateTimeFormat(pattern = "yyyy/MM/dd") Date fecha,
                                                                 @RequestParam("hora") Integer hora,
                                                                 @RequestParam("idCancha") Long idCancha) {
        return disponibilidadService.getDisponibilidadesPorFechaYHora(fecha, hora, idCancha);
    }
}

