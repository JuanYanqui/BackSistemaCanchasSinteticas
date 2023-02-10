package com.sistema.canchas.controller;

import com.sistema.canchas.model.Usuario;
import com.sistema.canchas.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {
    @Autowired
    private UsuarioService service;


    @RequestMapping(value = "/{idUsuario}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Optional<Usuario> porId(@PathVariable Long idUsuario){
        return service.porId(idUsuario);
    }

    @GetMapping("/li")
    public ResponseEntity<List<Usuario>> obtenerListali() {
        return new ResponseEntity<>(service.findByAll(), HttpStatus.OK);
    }

    @PostMapping("/cre")
    public ResponseEntity<Usuario> crearcli(@RequestBody Usuario usuario){
        return new ResponseEntity<>(service.save(usuario), HttpStatus.CREATED);
    }
    @PutMapping("/upd/{id}")
    public ResponseEntity<Usuario> UpdateUser(@RequestBody Usuario u,@PathVariable Long id){
        Usuario us=service.findById(id);
        us.setUsername(u.getUsername());
        us.setPassword(u.getPassword());
        return new ResponseEntity<>(service.save(us),HttpStatus.CREATED);

    }


    @DeleteMapping("/eli/{id}")
    public ResponseEntity <?> eliminarli(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "login/{username}/{password}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public Usuario login(@PathVariable String username, @PathVariable String password){
        return service.login(username, password);
    }


    @RequestMapping(value = "porUsername/{username}", method = RequestMethod.GET)
    @ResponseBody
    @CrossOrigin
    public boolean porUsername(@PathVariable String username){
        return service.porUsername(username);
    }


}
