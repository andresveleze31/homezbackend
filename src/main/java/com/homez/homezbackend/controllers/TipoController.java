package com.homez.homezbackend.controllers;

import com.homez.homezbackend.dto.TipoDTO;
import com.homez.homezbackend.dto.TipoIngresoDTO;
import com.homez.homezbackend.services.TipoIngresoService;
import com.homez.homezbackend.services.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
