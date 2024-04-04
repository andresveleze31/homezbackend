package com.homez.homezbackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homez.homezbackend.dto.ArrendatarioDTO;
import com.homez.homezbackend.services.ArrendatarioService;

@RestController
@RequestMapping("/api/homez/arrendatario")
public class ArrendatarioController {

    ArrendatarioService arrendatarioService;

    @Autowired
    public ArrendatarioController( ArrendatarioService arrendatarioService){
        this.arrendatarioService = arrendatarioService;

    }
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrendatarioDTO get(@PathVariable Integer id){
        return arrendatarioService.getArrendatario(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ArrendatarioDTO> get(){
        return arrendatarioService.getArrendatarios();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrendatarioDTO create(@RequestBody ArrendatarioDTO arrendatarioDTO){
        return arrendatarioService.createArrendatario(arrendatarioDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrendatarioDTO update(@RequestBody ArrendatarioDTO arrendatarioDTO){
        return arrendatarioService.createArrendatario(arrendatarioDTO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id){
        arrendatarioService.deleteArrendatario(id);
    }

}
