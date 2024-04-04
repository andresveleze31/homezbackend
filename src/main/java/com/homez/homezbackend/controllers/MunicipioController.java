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

import com.homez.homezbackend.dto.MunicipioDTO;
import com.homez.homezbackend.services.MunicipioService;

@RestController
@RequestMapping("/api/homez/municipio")
public class MunicipioController {

    MunicipioService municipioService;

    @Autowired
    public MunicipioController( MunicipioService municipioService){
        this.municipioService = municipioService;

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public MunicipioDTO get(@PathVariable Integer id){
        return municipioService.getMunicipio(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MunicipioDTO> get(){
        return municipioService.getMunicipios();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public MunicipioDTO create(@RequestBody MunicipioDTO municipioDTO){
        return municipioService.createMunicipio(municipioDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public MunicipioDTO update(@RequestBody MunicipioDTO municipioDTO){
        return municipioService.updateMunicipio(municipioDTO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id){
        municipioService.deleteMunicipio(id);
    }
}
