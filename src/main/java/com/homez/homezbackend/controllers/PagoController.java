package com.homez.homezbackend.controllers;

import com.homez.homezbackend.dto.BancoDTO;
import com.homez.homezbackend.dto.PagoDTO;
import com.homez.homezbackend.services.BancoService;
import com.homez.homezbackend.services.PagoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
