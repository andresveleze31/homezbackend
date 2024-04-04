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

import com.homez.homezbackend.dto.PagoDTO;
import com.homez.homezbackend.services.PagoService;

@RestController
@RequestMapping("/api/homez/pago")
public class PagoController {

    PagoService pagoService;

    @Autowired
    public PagoController(PagoService pagoService){
        this.pagoService = pagoService;

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public PagoDTO get(@PathVariable Integer id){
        return pagoService.getPago(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PagoDTO> get(){
        return pagoService.getPagos();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public PagoDTO create(@RequestBody PagoDTO pagoDTO){
        return pagoService.createPago(pagoDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public PagoDTO update(@RequestBody PagoDTO pagoDTO){
        return pagoService.updatePago(pagoDTO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id){
        pagoService.deletePago(id);
    }


}
