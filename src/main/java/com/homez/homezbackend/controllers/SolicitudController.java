package com.homez.homezbackend.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homez.homezbackend.dto.ArrendadorDTO;
import com.homez.homezbackend.dto.ArrendatarioDTO;
import com.homez.homezbackend.dto.PropiedadDTO;
import com.homez.homezbackend.dto.SolicitudDTO;
import com.homez.homezbackend.services.ArrendadorService;
import com.homez.homezbackend.services.ArrendatarioService;
import com.homez.homezbackend.services.SolicitudService;

@RestController
@RequestMapping("/api/homez/solicitud")
public class SolicitudController {

    SolicitudService solicitudService;

    @Autowired
    ArrendadorService arrendadorService;

    @Autowired
    ArrendatarioService arrendatarioService;

    @Autowired
    public SolicitudController(  SolicitudService solicitudService){
        this.solicitudService = solicitudService;

    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SolicitudDTO get(@PathVariable Integer id){
        return solicitudService.getSolicitud(id);
    }

    @GetMapping(value = "/propietario", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SolicitudDTO> getByPropietarioId(Authentication authentication) throws Exception {
        ArrendadorDTO arrendadorDTO = arrendadorService.autorizacion(authentication);
        if (arrendadorDTO == null || arrendadorDTO.getId() <= 0) {
            List<SolicitudDTO> sols = new ArrayList<>();
            return sols;
        }
        return solicitudService.getAllSolicitudesByPropietario(arrendadorDTO.getId());
    }

    @GetMapping(value = "/arrendatario", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SolicitudDTO> getByArrendatarioId(Authentication authentication) throws Exception {
        ArrendatarioDTO arrendatarioDTO = arrendatarioService.autorizacion(authentication);
        if (arrendatarioDTO == null || arrendatarioDTO.getId() <= 0) {
            List<SolicitudDTO> sols = new ArrayList<>();
            return sols;
        }
        return solicitudService.getAllSolicitudesByArrendatario(arrendatarioDTO.getId());
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SolicitudDTO> get(){
        return solicitudService.getAllSolicitudes();
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public SolicitudDTO create(Authentication authentication, @RequestBody SolicitudDTO solicitudDTO) throws Exception{
        ArrendatarioDTO arrendatarioDTO = arrendatarioService.autorizacion(authentication);
        if (arrendatarioDTO == null || arrendatarioDTO.getId() <= 0) {
            return null;
        }
        return solicitudService.createSolicitud(solicitudDTO);
    }

    @PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public SolicitudDTO update(Authentication authentication, @RequestBody SolicitudDTO solicitudDTO) throws Exception{

        ArrendadorDTO arrendadorDTO = arrendadorService.autorizacion(authentication);
        if (arrendadorDTO == null || arrendadorDTO.getId() <= 0) {
            return new SolicitudDTO();
        }

        return solicitudService.updateSolicitud(solicitudDTO);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public void delete(@PathVariable Integer id){
        solicitudService.deleteSolicitud(id);
    }

}
