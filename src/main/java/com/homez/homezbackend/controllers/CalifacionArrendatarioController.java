package com.homez.homezbackend.controllers;

import com.homez.homezbackend.dto.BancoDTO;
import com.homez.homezbackend.dto.CalificacionArrendatarioDTO;
import com.homez.homezbackend.services.BancoService;
import com.homez.homezbackend.services.CalificacionArrendatarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/homez/calarrendatario")
public class CalifacionArrendatarioController {

    CalificacionArrendatarioService calificacionArrendatarioService;

    @Autowired
    public CalifacionArrendatarioController( CalificacionArrendatarioService calificacionArrendatarioService){
        this.calificacionArrendatarioService = calificacionArrendatarioService;

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public CalificacionArrendatarioDTO get(@PathVariable Integer id){
        return calificacionArrendatarioService.getCalArrendatario(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<CalificacionArrendatarioDTO> get(){
        return calificacionArrendatarioService.getCalArrendatarios();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CalificacionArrendatarioDTO create(@RequestBody CalificacionArrendatarioDTO calificacionArrendatarioDTO){
        return calificacionArrendatarioService.createCalArrendatario(calificacionArrendatarioDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public CalificacionArrendatarioDTO update(@RequestBody CalificacionArrendatarioDTO calificacionArrendatarioDTO){
        return calificacionArrendatarioService.updateCalArrendatario(calificacionArrendatarioDTO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id){
        calificacionArrendatarioService.deleteCalArrendatario(id);
    }
}
