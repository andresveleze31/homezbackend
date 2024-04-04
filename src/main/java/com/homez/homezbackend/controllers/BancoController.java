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

import com.homez.homezbackend.dto.BancoDTO;
import com.homez.homezbackend.services.BancoService;

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
