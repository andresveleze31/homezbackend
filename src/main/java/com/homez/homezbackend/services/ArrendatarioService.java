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
import com.homez.homezbackend.entity.Arrendatario;
import com.homez.homezbackend.repository.ArrendatarioRepository;

@Service
public class ArrendatarioService {

    private ArrendatarioRepository arrendatarioRepository;
    ModelMapper modelMapper;


    //Constructor
    @Autowired
    ArrendatarioService(ArrendatarioRepository arrendatarioRepository, ModelMapper modelMapper){
        this.arrendatarioRepository = arrendatarioRepository;
        this.modelMapper = modelMapper;
    }

    public ArrendatarioDTO getArrendatario (Integer id) {
        Optional<Arrendatario> arrendatarioOptional = arrendatarioRepository.findById(id);
        ArrendatarioDTO arrendatarioDTO = null;

        if(arrendatarioOptional.isPresent()){
            Arrendatario arrendatario = arrendatarioOptional.get();
            arrendatarioDTO = modelMapper.map(arrendatario, ArrendatarioDTO.class);

        }

        return  arrendatarioDTO;
    }

    public ArrendatarioDTO getArrendatarioByCorreo(String correo, String contrasena) {
        Arrendatario arrendatario = arrendatarioRepository.findArrendatarioByCorreo(correo, contrasena);
        ArrendatarioDTO arrendatarioDTO = null;

        if (arrendatario != null) {
            arrendatarioDTO = modelMapper.map(arrendatario, ArrendatarioDTO.class);
        }

        return arrendatarioDTO;
    }

    public ArrendatarioDTO autorizacion( Authentication authentication ) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("-----------------------");
        System.out.println(  authentication.getName() );
        ArrendatarioDTO arrendador = objectMapper.readValue(authentication.getName(), ArrendatarioDTO.class);
        System.out.println("-----------------------"); 
        return arrendador;
    }

    public List<ArrendatarioDTO> getArrendatarios(){
        List<Arrendatario> arrendatarios =  (List<Arrendatario>) arrendatarioRepository.findAll();
        List<ArrendatarioDTO> arrendatarioDTOS = arrendatarios.stream().map(arrendatario -> modelMapper.map(arrendatario, ArrendatarioDTO.class)).collect(Collectors.toList());

        return arrendatarioDTOS;
    }

    public ArrendatarioDTO createArrendatario(ArrendatarioDTO arrendatarioDTO){
        Arrendatario arrendatario = modelMapper.map(arrendatarioDTO, Arrendatario.class);
        arrendatario = arrendatarioRepository.save(arrendatario);


        return modelMapper.map(arrendatario, ArrendatarioDTO.class);

    }

    public ArrendatarioDTO updateArrendatario(ArrendatarioDTO arrendatarioDTO){
        Arrendatario arrendatario = modelMapper.map(arrendatarioDTO, Arrendatario.class);
        arrendatario = arrendatarioRepository.save(arrendatario);

        return modelMapper.map(arrendatario, ArrendatarioDTO.class);
    }

    public void deleteArrendatario(Integer id){
        arrendatarioRepository.deleteById(id);
    }
}
