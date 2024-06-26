package com.homez.homezbackend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homez.homezbackend.dto.ArrendadorDTO;
import com.homez.homezbackend.dto.ArrendatarioDTO;
import com.homez.homezbackend.entity.Arrendador;
import com.homez.homezbackend.entity.Arrendatario;
import com.homez.homezbackend.repository.ArrendadorRepository;

@Service
public class ArrendadorService {

    private ArrendadorRepository arrendadorRepository;
    ModelMapper modelMapper;


    //Constructor
    @Autowired
    ArrendadorService(ArrendadorRepository arrendadorRepository, ModelMapper modelMapper){
        this.arrendadorRepository = arrendadorRepository;
        this.modelMapper = modelMapper;
    }
    public ArrendadorDTO getArrendador (Integer id) {
        Optional<Arrendador> arrendadorOpt = arrendadorRepository.findById(id);
        ArrendadorDTO arrendadorDTO = null;

        if(arrendadorOpt.isPresent()){
            Arrendador arrendador = arrendadorOpt.get();
            arrendadorDTO = modelMapper.map(arrendador, ArrendadorDTO.class);

        }

        return  arrendadorDTO;
    }

    public List<ArrendadorDTO> getArrendadores(){
        List<Arrendador> arrendadors =  (List<Arrendador>) arrendadorRepository.findAll();
        List<ArrendadorDTO> arrendadorDTOS = arrendadors.stream().map(arrendador -> modelMapper.map(arrendador, ArrendadorDTO.class)).collect(Collectors.toList());

        return arrendadorDTOS;
    }

    public ArrendadorDTO autorizacion( Authentication authentication ) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("-----------------------");
        System.out.println(  authentication.getName() );
        ArrendadorDTO arrendador = objectMapper.readValue(authentication.getName(), ArrendadorDTO.class);
        System.out.println("-----------------------"); 
        return arrendador;
    }

    public ArrendadorDTO getArrendadorByCorreo(String correo, String contrasena) {
        Arrendador arrendador = arrendadorRepository.findArrendatarioByCorreo(correo, contrasena);
        ArrendadorDTO arrendadorDTO = null;

        if (arrendador != null) {
            arrendadorDTO = modelMapper.map(arrendador, ArrendadorDTO.class);
        }

        return arrendadorDTO;
    }

    public ArrendadorDTO createArrendador(ArrendadorDTO arrendadorDTO){
        Arrendador arrendador = modelMapper.map(arrendadorDTO, Arrendador.class);
        arrendador = arrendadorRepository.save(arrendador);

        return modelMapper.map(arrendador, ArrendadorDTO.class);
    }

    public ArrendadorDTO updateArrendador(ArrendadorDTO arrendadorDTO){
        Arrendador arrendador = modelMapper.map(arrendadorDTO, Arrendador.class);
        arrendador = arrendadorRepository.save(arrendador);

        return modelMapper.map(arrendador, ArrendadorDTO.class);
    }

    public void deleteArrendador(Integer id){
        arrendadorRepository.deleteById(id);
    }


}
