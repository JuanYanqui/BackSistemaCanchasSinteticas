package com.sistema.canchas.controller;

import com.sistema.canchas.model.Blacklist;
import com.sistema.canchas.service.BlacklistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/blacklist")
public class BlacklistController {
    @Autowired
    BlacklistService blacklistService;
    @GetMapping("/li")
    public ResponseEntity<List<Blacklist>> getList(){
        return new ResponseEntity<>(blacklistService.findByAll(), HttpStatus.OK);
    }
}
