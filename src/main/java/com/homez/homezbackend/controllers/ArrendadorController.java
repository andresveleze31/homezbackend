package com.homez.homezbackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homez.homezbackend.dto.ArrendadorDTO;
import com.homez.homezbackend.dto.PropiedadDTO;
import com.homez.homezbackend.services.ArrendadorService;

@RestController
@RequestMapping("/api/homez/arrendador")
public class ArrendadorController {

    @Autowired
    ArrendadorService arrendadorService;

    @Autowired
    public ArrendadorController(ArrendadorService arrendadorService) {
        this.arrendadorService = arrendadorService;
    }

    @GetMapping(value = "/one", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrendadorDTO get(Authentication authentication) throws Exception {
        ArrendadorDTO arrendadorDTO = arrendadorService.autorizacion(authentication);
        return arrendadorService.getArrendador(arrendadorDTO.getId());
    }

    @CrossOrigin
    @GetMapping(value = "/auth", produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrendadorDTO arrendador(Authentication authentication) throws Exception {
        System.out.println(authentication.getName());
        return arrendadorService.autorizacion(authentication);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ArrendadorDTO> get() {
        return arrendadorService.getArrendadores();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrendadorDTO create(@RequestBody ArrendadorDTO arrendadorDTO) {
        return arrendadorService.createArrendador(arrendadorDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ArrendadorDTO update(Authentication authentication, @RequestBody ArrendadorDTO arrendadorDTO) throws Exception {

        ArrendadorDTO arrendadorDTO2 = arrendadorService.autorizacion(authentication);
        if(arrendadorDTO2 == null || arrendadorDTO2.getId() <= 0){
            return new ArrendadorDTO();
        }

        return arrendadorService.updateArrendador(arrendadorDTO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id) {
        arrendadorService.deleteArrendador(id);
    }
}
