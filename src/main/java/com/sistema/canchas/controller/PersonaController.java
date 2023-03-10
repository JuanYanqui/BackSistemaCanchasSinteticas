package com.sistema.canchas.controller;

import com.sistema.canchas.model.Establecimiento;
import com.sistema.canchas.model.Persona;
import com.sistema.canchas.model.Rol;
import com.sistema.canchas.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/persona")
@CrossOrigin("*")
public class PersonaController {
    @Autowired
    private PersonaService personaService;

    @GetMapping("/li")
    public ResponseEntity<List<Persona>> obtenerListali() {
        return new ResponseEntity<>(personaService.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/cre")
    public ResponseEntity<Persona> crearcli(@RequestBody Persona persona){
        return new ResponseEntity<>(personaService.save(persona), HttpStatus.CREATED);
    }

    @PutMapping("/upd/{ced}")
    public ResponseEntity<Persona> upddatePersona(@RequestBody Persona p,@PathVariable String ced){
        Persona pe=personaService.porCedula(ced);
        pe.setNombre(p.getNombre());
        pe.setApellido(p.getApellido());
        pe.setFechaNacimmiento(p.getFechaNacimmiento());
        pe.setGenero(p.getGenero());
        pe.setDireccion(p.getDireccion());
        pe.setEmail(p.getEmail());
        pe.setTelefono(p.getTelefono());
        pe.setCelular(p.getCelular());
        pe.setFoto(p.getFoto());
        return new ResponseEntity<>(personaService.save(pe),HttpStatus.CREATED);
    }

    @DeleteMapping("/eli/{id}")
    public ResponseEntity <?> eliminarli(@PathVariable Long id) {
        personaService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/{idPersona}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Optional<Persona> porId(@PathVariable Long idPersona){
        return personaService.porId(idPersona);
    }


    @RequestMapping(value = "byCedula/{cedula}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Persona porCedula(@PathVariable String cedula){
        return personaService.porCedula(cedula);
    }


   /*@RequestMapping(value = "/listbyestable/{idPersona}", method = RequestMethod.GET)
    @ResponseBody
    public List<Establecimiento>  getEstbalecimientos(@PathVariable Long idPersona){
        return personaService.listaByEstable(idPersona);
    }
*/

    @RequestMapping(value = "valced/{ced}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public boolean valcedu(@PathVariable String ced){
        int suma=0;
        int a[]=new int [ced.length()/2];
        int b[]=new int [(ced.length()/2)];
        int c=0;
        int d=1;
        for (int i = 0; i < ced.length()/2; i++) {
            a[i]=Integer.parseInt(String.valueOf(ced.charAt(c)));
            c=c+2;
            if (i < (ced.length()/2)-1) {
                b[i]=Integer.parseInt(String.valueOf(ced.charAt(d)));
                d=d+2;
            }
        }

        for (int i = 0; i < a.length; i++) {
            a[i]=a[i]*2;
            if (a[i] >9){
                a[i]=a[i]-9;
            }
            suma=suma+a[i]+b[i];
        }
        int auced=suma/10;
        int dec=(auced+1)*10;
        if ((dec - suma) == Integer.parseInt(String.valueOf(ced.charAt(ced.length()-1))))
            return true;
        else
        if(suma%10==0 && ced.charAt(ced.length()-1)=='0'){
            return true;
        }else{
            return false;
        }
    }

}
