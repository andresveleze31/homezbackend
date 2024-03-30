package com.homez.homezbackend.services;

import com.homez.homezbackend.dto.ArrendadorDTO;
import com.homez.homezbackend.dto.ArrendatarioDTO;
import com.homez.homezbackend.entity.Arrendador;
import com.homez.homezbackend.entity.Arrendatario;
import com.homez.homezbackend.repository.ArrendadorRepository;
import com.homez.homezbackend.repository.ArrendatarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public List<ArrendatarioDTO> getArrendatarios(){
        List<Arrendatario> arrendatarios =  (List<Arrendatario>) arrendatarioRepository.findAll();
        List<ArrendatarioDTO> arrendatarioDTOS = arrendatarios.stream().map(arrendatario -> modelMapper.map(arrendatario, ArrendatarioDTO.class)).collect(Collectors.toList());

        return arrendatarioDTOS;
    }

    public ArrendatarioDTO createArrendatario(ArrendatarioDTO arrendatarioDTO){
        Arrendatario arrendatario = modelMapper.map(arrendatarioDTO, Arrendatario.class);
        arrendatario = arrendatarioRepository.save(arrendatario);

        return arrendatarioDTO;
    }

    public ArrendatarioDTO updateArrendatario(ArrendatarioDTO arrendatarioDTO){
        Arrendatario arrendatario = modelMapper.map(arrendatarioDTO, Arrendatario.class);
        arrendatario = arrendatarioRepository.save(arrendatario);

        return arrendatarioDTO;
    }

    public void deleteArrendatario(Integer id){
        arrendatarioRepository.deleteById(id);
    }
}
