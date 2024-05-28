package com.homez.homezbackend.controllers;

import java.util.ArrayList;
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
import com.homez.homezbackend.services.PropiedadService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/homez/propiedad")
public class PropiedadController {
    PropiedadService propiedadService;

    @Autowired
    ArrendadorService arrendadorService;

    @Autowired
    public PropiedadController(PropiedadService propiedadService) {
        this.propiedadService = propiedadService;

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PropiedadDTO getById(@PathVariable Integer id) {
        return propiedadService.getPropiedad(id);
    }

    //Cambio
    @GetMapping(value = "/propietario", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PropiedadDTO> getByPropietarioId(Authentication authentication) throws Exception {
        ArrendadorDTO arrendadorDTO = arrendadorService.autorizacion(authentication);
        if (arrendadorDTO == null || arrendadorDTO.getId() <= 0) {
            List<PropiedadDTO> props = new ArrayList<>();
            return props;
        }
        return propiedadService.getAllPropiedadesByArrendador(arrendadorDTO.getId());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PropiedadDTO> get() {
        return propiedadService.getAllPropiedades();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public PropiedadDTO create(Authentication authentication, @RequestBody PropiedadDTO propiedadDTO) throws Exception{
        ArrendadorDTO arrendadorDTO = arrendadorService.autorizacion(authentication);
        if(arrendadorDTO == null || arrendadorDTO.getId() <= 0){
            return new PropiedadDTO();
        }
        return propiedadService.createPropiedad(propiedadDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public PropiedadDTO update(Authentication authentication, @RequestBody PropiedadDTO propiedadDTO) throws Exception {

        ArrendadorDTO arrendadorDTO = arrendadorService.autorizacion(authentication);
        if (arrendadorDTO == null || arrendadorDTO.getId() <= 0) {
            return new PropiedadDTO();
        }
        return propiedadService.updatePropiedad(propiedadDTO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id) {
        propiedadService.deletePropiedad(id);
    }

}
