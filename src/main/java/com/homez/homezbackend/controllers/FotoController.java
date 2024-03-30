package com.homez.homezbackend.controllers;

import com.homez.homezbackend.dto.FotoDTO;
import com.homez.homezbackend.dto.MunicipioDTO;
import com.homez.homezbackend.services.FotoService;
import com.homez.homezbackend.services.MunicipioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
