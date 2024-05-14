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

import com.homez.homezbackend.dto.ArrendadorDTO;
import com.homez.homezbackend.services.ArrendadorService;

@RestController
@RequestMapping("/api/homez/arrendador")
public class ArrendadorController {

    ArrendadorService arrendadorService;

    @Autowired
    public ArrendadorController( ArrendadorService arrendadorService){
        this.arrendadorService = arrendadorService;
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrendadorDTO get(@PathVariable Integer id){
        return arrendadorService.getArrendador(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ArrendadorDTO> get(){
        return arrendadorService.getArrendadores();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrendadorDTO create(@RequestBody ArrendadorDTO arrendadorDTO){
        return arrendadorService.createArrendador(arrendadorDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrendadorDTO update(@RequestBody ArrendadorDTO arrendadorDTO){
        return arrendadorService.updateArrendador(arrendadorDTO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id){
        arrendadorService.deleteArrendador(id);
    }
}
