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

import com.homez.homezbackend.dto.SolicitudDTO;
import com.homez.homezbackend.services.SolicitudService;

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
