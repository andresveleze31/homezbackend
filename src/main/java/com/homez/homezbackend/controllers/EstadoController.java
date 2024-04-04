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

import com.homez.homezbackend.dto.EstadoDTO;
import com.homez.homezbackend.services.EstadoService;

@RestController
@RequestMapping("/api/homez/estado")
public class EstadoController {

    EstadoService estadoService;

    @Autowired
    public EstadoController( EstadoService estadoService){
        this.estadoService = estadoService;

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public EstadoDTO get(@PathVariable Integer id){
        return estadoService.getEstado(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EstadoDTO> get(){
        return estadoService.getEstados();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public EstadoDTO create(@RequestBody EstadoDTO estadoDTO){
        return estadoService.createEstado(estadoDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public EstadoDTO update(@RequestBody EstadoDTO estadoDTO){
        return estadoService.updateEstado(estadoDTO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id){
        estadoService.deleteEstado(id);
    }

}
