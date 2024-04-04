package com.homez.homezbackend.services;

import com.homez.homezbackend.dto.DepartamentoDTO;
import com.homez.homezbackend.dto.FotoDTO;
import com.homez.homezbackend.dto.MunicipioDTO;
import com.homez.homezbackend.entity.Departamento;
import com.homez.homezbackend.entity.Municipio;
import com.homez.homezbackend.repository.DepartamentoRepository;
import com.homez.homezbackend.repository.MunicipioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MunicipioService {

    private MunicipioRepository municipioRepository;
    ModelMapper modelMapper;


    //Constructor
    @Autowired
    MunicipioService( MunicipioRepository municipioRepository, ModelMapper modelMapper){
        this.municipioRepository = municipioRepository;
        this.modelMapper = modelMapper;
    }

    public MunicipioDTO getMunicipio (Integer id) {
        Optional<Municipio> municipioOptional = municipioRepository.findById(id);
        MunicipioDTO municipioDTO = null;

        if(municipioOptional.isPresent()){
            Municipio municipio = municipioOptional.get();
            municipioDTO = modelMapper.map(municipio, MunicipioDTO.class);

        }

        return  municipioDTO;
    }

    public List<MunicipioDTO> getMunicipios(){
        List<Municipio> municipios =  (List<Municipio>) municipioRepository.findAll();
        List<MunicipioDTO> municipioDTOS = municipios.stream().map(municipio -> modelMapper.map(municipio, MunicipioDTO.class)).collect(Collectors.toList());

        return municipioDTOS;
    }

    public MunicipioDTO createMunicipio(MunicipioDTO municipioDTO){
        Municipio municipio = modelMapper.map(municipioDTO, Municipio.class);
        municipio = municipioRepository.save(municipio);

        return modelMapper.map(municipio, MunicipioDTO.class);
    }

    public MunicipioDTO updateMunicipio(MunicipioDTO municipioDTO){
        Municipio municipio = modelMapper.map(municipioDTO, Municipio.class);
        municipio = municipioRepository.save(municipio);

        return modelMapper.map(municipio, MunicipioDTO.class);
    }

    public void deleteMunicipio(Integer id){
        municipioRepository.deleteById(id);
    }
}
