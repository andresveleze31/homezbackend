package com.homez.homezbackend.controllers;

import com.homez.homezbackend.dto.PropiedadDTO;
import com.homez.homezbackend.dto.SolicitudDTO;
import com.homez.homezbackend.services.PropiedadService;
import com.homez.homezbackend.services.SolicitudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/homez/solicitud")
public class SolicitudController {

    SolicitudService solicitudService;

    @Autowired
    public SolicitudController(  SolicitudService solicitudService){
        this.solicitudService = solicitudService;

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SolicitudDTO get(@PathVariable Integer id){
        return solicitudService.getSolicitud(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SolicitudDTO> get(){
        return solicitudService.getAllSolicitudes();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public SolicitudDTO create(@RequestBody SolicitudDTO solicitudDTO){
        return solicitudService.createSolicitud(solicitudDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public SolicitudDTO update(@RequestBody SolicitudDTO solicitudDTO){
        return solicitudService.updateSolicitud(solicitudDTO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id){
        solicitudService.deleteSolicitud(id);
    }

}
