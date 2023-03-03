package com.sistema.canchas.controller;

import com.sistema.canchas.model.Cancha;
import com.sistema.canchas.model.Disponibilidad;
import com.sistema.canchas.repository.DisponibilidadRepository;
import com.sistema.canchas.service.DisponibilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/disponibilidad")
@CrossOrigin("*")
public class DisponibilidadController {
    @Autowired
    DisponibilidadService disponibilidadService;
    @Autowired
    DisponibilidadRepository disponibilidadRepository;

    @GetMapping("/li")
    public ResponseEntity<List<Disponibilidad>>getList(){
        return new ResponseEntity<>(disponibilidadService.findByAll(), HttpStatus.OK);
    }
    @PostMapping("/cre")
    public ResponseEntity<Disponibilidad> crearcancha(@RequestBody Disponibilidad disponibilidad){

        return new ResponseEntity<>(disponibilidadService.save(disponibilidad), HttpStatus.CREATED);
    }
    /*@PostMapping("/cre")
    public ResponseEntity<?> crearDisponibilidad(@RequestBody Disponibilidad disponibilidad) {
        boolean existeDisponibilidad = disponibilidadService.existsDisponibilidadByFechaAndHoraAndCanchaId(
                disponibilidad.getFecha(), disponibilidad.getHora(), disponibilidad.getCancha().getIdCancha());

        if (existeDisponibilidad) {
            return ResponseEntity.badRequest().body("Ya existe una disponibilidad con esa fecha, hora e idCancha.");
        }

        // Si no existe una disponibilidad con la misma fecha, hora e idCancha, guardamos la nueva disponibilidad
        Disponibilidad nuevaDisponibilidad = disponibilidadService.save(disponibilidad);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevaDisponibilidad);
    }*/


    /*@PostMapping("/crear")
    public ResponseEntity<?> agregarDisponibilidad(@RequestBody Disponibilidad nuevaDisponibilidad) {
        // Verificar si ya existe una disponibilidad con la misma fecha, hora y cancha
        if (disponibilidadRepository.existsByFechaAndHoraAndCancha(nuevaDisponibilidad.getFecha(),
                nuevaDisponibilidad.getHora(),
                nuevaDisponibilidad.getCancha())) {
            return ResponseEntity.badRequest().body("Ya existe una disponibilidad para esa fecha, hora y cancha");
        }

        // Si no existe, agregar la disponibilidad a la base de datos
        disponibilidadRepository.save(nuevaDisponibilidad);
        return ResponseEntity.ok().build();
    }*/

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

   /* @GetMapping("")
    public List<Disponibilidad> getDisponibilidadesPorFechaYHora(@RequestParam("fecha")Date fecha,
                                                                 @RequestParam("hora") Integer hora,
                                                                 @RequestParam("idCancha") Long idCancha) {
        return disponibilidadService.getDisponibilidadesPorFechaYHora(fecha, hora, idCancha);
    }*/


   /* @GetMapping("/buscar")

    public boolean verificarDisponibilidad(@RequestParam(name = "fecha") String fecha,
                                                           @RequestParam(name = "hora") Integer hora,
                                                           @RequestParam(name = "idCancha") Long idCancha) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fechad = null;
        try {
            fechad = formatter.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return disponibilidadService.existsDisponibilidadByFechaAndHoraAndCanchaId(fechad, hora, idCancha);
    }*/

    @GetMapping("/validarRegistros/{fecha}/{hora}/{idCancha}")
    public boolean validarRegistros(@PathVariable String fecha, @PathVariable Integer hora, @PathVariable Long idCancha) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date fechas = null;
        try {
            fechas = formatter.parse(fecha);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return disponibilidadService.existsDisponibilidadByFechaAndHoraAndCanchaId(fechas, hora, idCancha);
    }

    @GetMapping("/fechas-horas/{idCancha}")
    public ResponseEntity<List<Object[]>> getFechasHorasByCanchaId(@PathVariable Long idCancha) {
        List<Object[]> fechasHoras = disponibilidadService.getFechasHorasByCanchaId(idCancha);
        return ResponseEntity.ok(fechasHoras);
    }


}

