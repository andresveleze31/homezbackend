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

import com.homez.homezbackend.dto.FotoDTO;
import com.homez.homezbackend.services.FotoService;

@RestController
@RequestMapping("/api/homez/foto")
public class FotoController {

    FotoService fotoService;

    @Autowired
    public FotoController(FotoService fotoService){
        this.fotoService = fotoService;

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FotoDTO get(@PathVariable Integer id){
        return fotoService.getFoto(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FotoDTO> get(){
        return fotoService.getFotos();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public FotoDTO create(@RequestBody FotoDTO fotoDTO){
        return fotoService.createFoto(fotoDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public FotoDTO update(@RequestBody FotoDTO fotoDTO){
        return fotoService.updateFoto(fotoDTO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id){
        fotoService.deleteFoto(id);
    }
}
