package com.homez.homezbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.homez.homezbackend.dto.ArrendatarioDTO;
import com.homez.homezbackend.dto.TokenDTO;
import com.homez.homezbackend.security.JWTTokenService;
import com.homez.homezbackend.services.ArrendatarioService;


@RestController
@RequestMapping(value = "/jwt/security/autenticar")
public class AutenticacionController {

    @Autowired
    JWTTokenService jwtTokenService;
    
    @Autowired
    ArrendatarioService arrendatarioService;


    //Devuelve Token Dado el Arrendatario Completo
    @CrossOrigin
    @PostMapping(value = "/autenticar", produces = MediaType.APPLICATION_JSON_VALUE)
    public TokenDTO autenticar(@RequestBody ArrendatarioDTO arrendatarioDTO) {
        return new TokenDTO(jwtTokenService.generarToken(arrendatarioDTO), arrendatarioDTO);
    }

    //Devuelve Token Dado Correo y Contraseña
    @CrossOrigin
    @PostMapping(value = "/autenticar-correo-contrasena", produces = MediaType.APPLICATION_JSON_VALUE)
    public String autenticar(@RequestParam String correo, @RequestParam String contrasena) {
        ArrendatarioDTO arrendatarioDTO = arrendatarioService.getArrendatarioByCorreo(correo, contrasena);
        if(arrendatarioDTO != null){
            return jwtTokenService.generarToken(arrendatarioDTO);
        }
        return "Cuenta de Arrendatario No Encontrada";
    }
}