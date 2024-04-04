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

import com.homez.homezbackend.dto.TipoDTO;
import com.homez.homezbackend.services.TipoService;

@RestController
@RequestMapping("/api/homez/tipo")
public class TipoController {

    TipoService tipoService;

    @Autowired
    public TipoController( TipoService tipoService){
        this.tipoService = tipoService;

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TipoDTO get(@PathVariable Integer id){
        return tipoService.getTipo(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TipoDTO> get(){
        return tipoService.getAllTipo();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public TipoDTO create(@RequestBody TipoDTO tipoDTO){
        return tipoService.createTipo(tipoDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public TipoDTO update(@RequestBody TipoDTO tipoDTO){
        return tipoService.updateTipo(tipoDTO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id){
        tipoService.deleteTipo(id);
    }
}
