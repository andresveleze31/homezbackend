package com.homez.homezbackend.services;

import com.homez.homezbackend.dto.PropiedadDTO;
import com.homez.homezbackend.dto.TipoIngresoDTO;
import com.homez.homezbackend.entity.Propiedad;
import com.homez.homezbackend.entity.TipoIngreso;
import com.homez.homezbackend.repository.PropiedadRepository;
import com.homez.homezbackend.repository.TipoIngresoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PropiedadService {

    private PropiedadRepository propiedadRepository;
    ModelMapper modelMapper;


    //Constructor
    @Autowired
    PropiedadService( PropiedadRepository propiedadRepository, ModelMapper modelMapper){
        this.propiedadRepository = propiedadRepository;
        this.modelMapper = modelMapper;
    }

    public PropiedadDTO getPropiedad (Integer id) {
        Optional<Propiedad> propiedadOptional = propiedadRepository.findById(id);
        PropiedadDTO propiedadDTO = null;

        if(propiedadOptional.isPresent()){
            Propiedad propiedad = propiedadOptional.get();
            propiedadDTO = modelMapper.map(propiedad, PropiedadDTO.class);

        }

        return  propiedadDTO;
    }

    public List<PropiedadDTO> getAllPropiedades(){
        List<Propiedad> propiedads =  (List<Propiedad>) propiedadRepository.findAll();
        List<PropiedadDTO> propiedadDTOS = propiedads.stream().map(propiedad -> modelMapper.map(propiedad, PropiedadDTO.class)).collect(Collectors.toList());

        return propiedadDTOS;
    }

    public PropiedadDTO createPropiedad(PropiedadDTO propiedadDTO){
        Propiedad propiedad = modelMapper.map(propiedadDTO, Propiedad.class);
        propiedad = propiedadRepository.save(propiedad);

        return propiedadDTO;
    }

    public PropiedadDTO updatePropiedad(PropiedadDTO propiedadDTO){
        Propiedad propiedad = modelMapper.map(propiedadDTO, Propiedad.class);
        propiedad = propiedadRepository.save(propiedad);

        return propiedadDTO;
    }

    public void deletePropiedad(Integer id){
        propiedadRepository.deleteById(id);
    }
}
