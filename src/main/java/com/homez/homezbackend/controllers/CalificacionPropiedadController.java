package com.homez.homezbackend.controllers;


import com.homez.homezbackend.dto.CalificacionArrendatarioDTO;
import com.homez.homezbackend.dto.CalificacionPropiedadDTO;
import com.homez.homezbackend.services.CalificacionArrendatarioService;
import com.homez.homezbackend.services.CalificacionPropiedadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/homez/calpropiedad")
public class CalificacionPropiedadController {

    CalificacionPropiedadService calificacionPropiedadService;

    @Autowired
    public CalificacionPropiedadController( CalificacionPropiedadService calificacionPropiedadService){
        this.calificacionPropiedadService = calificacionPropiedadService;

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CalificacionPropiedadDTO get(@PathVariable Integer id){
        return calificacionPropiedadService.getCalPropiedad(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CalificacionPropiedadDTO> get(){
        return calificacionPropiedadService.getCalPropiedades();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CalificacionPropiedadDTO create(@RequestBody CalificacionPropiedadDTO calificacionPropiedadDTO){
        return calificacionPropiedadService.createCalPropiedad(calificacionPropiedadDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CalificacionPropiedadDTO update(@RequestBody CalificacionPropiedadDTO calificacionPropiedadDTO){
        return calificacionPropiedadService.updateCalPropiedad(calificacionPropiedadDTO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id){
        calificacionPropiedadService.deleteCalPropiedad(id);
    }
}
