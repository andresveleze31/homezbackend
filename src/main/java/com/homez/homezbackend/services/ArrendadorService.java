package com.homez.homezbackend.services;

import com.homez.homezbackend.dto.ArrendadorDTO;
import com.homez.homezbackend.entity.Arrendador;
import com.homez.homezbackend.repository.ArrendadorRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public ArrendadorDTO createArrendador(ArrendadorDTO arrendadorDTO){
        Arrendador arrendador = modelMapper.map(arrendadorDTO, Arrendador.class);
        arrendador = arrendadorRepository.save(arrendador);

        return arrendadorDTO;
    }

    public ArrendadorDTO updateArrendador(ArrendadorDTO arrendadorDTO){
        Arrendador arrendador = modelMapper.map(arrendadorDTO, Arrendador.class);
        arrendador = arrendadorRepository.save(arrendador);

        return arrendadorDTO;
    }

    public void deleteArrendador(Integer id){
        arrendadorRepository.deleteById(id);
    }


}
