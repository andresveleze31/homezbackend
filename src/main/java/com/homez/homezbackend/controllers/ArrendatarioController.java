package com.homez.homezbackend.controllers;

import com.homez.homezbackend.dto.ArrendadorDTO;
import com.homez.homezbackend.dto.ArrendatarioDTO;
import com.homez.homezbackend.services.ArrendadorService;
import com.homez.homezbackend.services.ArrendatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
