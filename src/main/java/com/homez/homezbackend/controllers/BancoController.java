package com.homez.homezbackend.controllers;

import com.homez.homezbackend.dto.BancoDTO;
import com.homez.homezbackend.dto.DepartamentoDTO;
import com.homez.homezbackend.services.BancoService;
import com.homez.homezbackend.services.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/homez/banco")
public class BancoController {
    BancoService bancoService;

    @Autowired
    public BancoController( BancoService bancoService){
        this.bancoService = bancoService;

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public BancoDTO get(@PathVariable Integer id){
        return bancoService.getBanco(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<BancoDTO> get(){
        return bancoService.getBancos();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public BancoDTO create(@RequestBody BancoDTO bancoDTO){
        return bancoService.createBanco(bancoDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public BancoDTO update(@RequestBody BancoDTO bancoDTO){
        return bancoService.updateBanco(bancoDTO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id){
        bancoService.deleteBanco(id);
    }
}
