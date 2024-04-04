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

import com.homez.homezbackend.dto.TipoIngresoDTO;
import com.homez.homezbackend.services.TipoIngresoService;
@RestController
@RequestMapping("/api/homez/tipoingreso")
public class TipoIngresoController {

    TipoIngresoService tipoIngresoService;

    @Autowired
    public TipoIngresoController( TipoIngresoService tipoIngresoService){
        this.tipoIngresoService = tipoIngresoService;

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TipoIngresoDTO get(@PathVariable Integer id){
        return tipoIngresoService.getTipoIngreso(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TipoIngresoDTO> get(){
        return tipoIngresoService.getAllTipoIngreso();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public TipoIngresoDTO create(@RequestBody TipoIngresoDTO tipoIngresoDTO){
        return tipoIngresoService.createTipoIngreso(tipoIngresoDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public TipoIngresoDTO update(@RequestBody TipoIngresoDTO tipoIngresoDTO){
        return tipoIngresoService.updateTipoIngreso(tipoIngresoDTO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id){
        tipoIngresoService.deleteTipoIngreso(id);
    }
}
