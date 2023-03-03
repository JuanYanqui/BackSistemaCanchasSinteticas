package com.sistema.canchas.controller;

import com.sistema.canchas.model.*;
import com.sistema.canchas.service.PagoReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pagoReserva")
@CrossOrigin("*")
public class PagoReservaController {
    @Autowired
    PagoReservaService pagoReservaService;
    @GetMapping("/li")
    public ResponseEntity<List<PagoReserva>> getList(){
        return new ResponseEntity<>(pagoReservaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/cre")
    public ResponseEntity<PagoReserva> crearcli(@RequestBody PagoReserva pagoReserva){
        return new ResponseEntity<>(pagoReservaService.save(pagoReserva), HttpStatus.CREATED);
    }

    @PutMapping("/upd/{id}")
    public ResponseEntity<PagoReserva> Update(@RequestBody PagoReserva p,@PathVariable Long id){;
        PagoReserva pa=pagoReservaService.findById(id);
        pa.setFecha_pago(p.getFecha_pago());
        pa.setFoto(p.getFoto());
        pa.setEstadopago(p.getEstadopago());
        return new ResponseEntity<>(pagoReservaService.save(pa),HttpStatus.CREATED);

    }

    @DeleteMapping("/eli/{id}")
    public ResponseEntity <?> eliminarli(@PathVariable Long id) {
        pagoReservaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{idPago_Reserva}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Optional<PagoReserva> porId(@PathVariable Long idPago_Reserva) {
        return pagoReservaService.porId(idPago_Reserva);
    }


    @GetMapping("/pago/{idPersona}")
    public List<PagoReserva> getReservasByClienteId(@PathVariable Long idPersona) {
        return pagoReservaService.findByReservaclienteIdPersona(idPersona);
    }

    @DeleteMapping("/pagos/{idPagoReserva}")
    public ResponseEntity<Void> deletePagoReserva(@PathVariable Long idPagoReserva) {
        pagoReservaService.deletePagoReserva(idPagoReserva);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/pagosporestablecimiento/{idEstablecimiento}")
    public List<PagoReserva> obtenerPagosPorEstablecimiento(@PathVariable Long idEstablecimiento) {
        return pagoReservaService.obtenerPagosPorEstablecimiento(idEstablecimiento);
    }
}
