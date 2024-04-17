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

import com.homez.homezbackend.dto.PropiedadDTO;
import com.homez.homezbackend.services.PropiedadService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/homez/propiedad")
public class PropiedadController {
    PropiedadService propiedadService;

    @Autowired
    public PropiedadController(  PropiedadService propiedadService){
        this.propiedadService = propiedadService;

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PropiedadDTO getById(@PathVariable Integer id) {
        return propiedadService.getPropiedad(id);
    }

    @GetMapping(value = "/propietario/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PropiedadDTO> getByPropietarioId(@PathVariable Integer id) {
        return propiedadService.getAllPropiedadesByArrendador(id);
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
