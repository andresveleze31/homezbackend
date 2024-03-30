package com.homez.homezbackend.controllers;

import com.homez.homezbackend.dto.DepartamentoDTO;
import com.homez.homezbackend.dto.MunicipioDTO;
import com.homez.homezbackend.services.DepartamentoService;
import com.homez.homezbackend.services.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
