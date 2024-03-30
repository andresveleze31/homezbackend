package com.homez.homezbackend.controllers;

import com.homez.homezbackend.dto.MunicipioDTO;
import com.homez.homezbackend.dto.TipoIngresoDTO;
import com.homez.homezbackend.services.MunicipioService;
import com.homez.homezbackend.services.TipoIngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
