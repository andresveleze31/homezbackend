package com.homez.homezbackend.controllers;

import com.homez.homezbackend.dto.ArrendadorDTO;
import com.homez.homezbackend.dto.DepartamentoDTO;
import com.homez.homezbackend.services.ArrendadorService;
import com.homez.homezbackend.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/homez/departamento")
public class DepartamentoController {

    DepartamentoService departamentoService;

    @Autowired
    public DepartamentoController( DepartamentoService departamentoService){
        this.departamentoService = departamentoService;

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DepartamentoDTO get(@PathVariable Integer id){
        return departamentoService.getDepartamento(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DepartamentoDTO> get(){
        return departamentoService.getDepartamentos();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public DepartamentoDTO create(@RequestBody DepartamentoDTO departamentoDTO){
        return departamentoService.createDepartamento(departamentoDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public DepartamentoDTO update(@RequestBody DepartamentoDTO departamentoDTO){
        return departamentoService.updateDepartamento(departamentoDTO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id){
        departamentoService.deleteDepartamento(id);
    }
}
