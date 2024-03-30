package com.homez.homezbackend.controllers;

import com.homez.homezbackend.dto.PropiedadDTO;
import com.homez.homezbackend.dto.TipoDTO;
import com.homez.homezbackend.services.PropiedadService;
import com.homez.homezbackend.services.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/homez/propiedad")
public class PropiedadController {
    PropiedadService propiedadService;

    @Autowired
    public PropiedadController(  PropiedadService propiedadService){
        this.propiedadService = propiedadService;

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PropiedadDTO get(@PathVariable Integer id){
        return propiedadService.getPropiedad(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PropiedadDTO> get(){
        return propiedadService.getAllPropiedades();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public PropiedadDTO create(@RequestBody PropiedadDTO propiedadDTO){
        return propiedadService.createPropiedad(propiedadDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public PropiedadDTO update(@RequestBody PropiedadDTO propiedadDTO){
        return propiedadService.updatePropiedad(propiedadDTO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id){
        propiedadService.deletePropiedad(id);
    }

}
