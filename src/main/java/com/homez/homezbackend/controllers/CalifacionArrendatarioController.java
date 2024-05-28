package com.homez.homezbackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homez.homezbackend.dto.ArrendatarioDTO;
import com.homez.homezbackend.dto.CalificacionArrendatarioDTO;
import com.homez.homezbackend.services.ArrendadorService;
import com.homez.homezbackend.services.ArrendatarioService;
import com.homez.homezbackend.services.CalificacionArrendatarioService;

@RestController
@RequestMapping("/api/homez/calarrendatario")
public class CalifacionArrendatarioController {

    CalificacionArrendatarioService calificacionArrendatarioService;

    @Autowired
    ArrendatarioService arrendatarioService;

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
    public CalificacionArrendatarioDTO create(Authentication authentication, @RequestBody CalificacionArrendatarioDTO calificacionArrendatarioDTO) throws Exception{
        ArrendatarioDTO arrendadorDTO2 = arrendatarioService.autorizacion(authentication);
        if (arrendadorDTO2 == null || arrendadorDTO2.getId() <= 0) {
            return null;
        }
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
