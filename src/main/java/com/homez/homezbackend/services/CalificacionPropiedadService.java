package com.homez.homezbackend.services;

import com.homez.homezbackend.dto.CalificacionArrendatarioDTO;
import com.homez.homezbackend.dto.CalificacionPropiedadDTO;
import com.homez.homezbackend.dto.EstadoDTO;
import com.homez.homezbackend.entity.CalificacionPropiedad;
import com.homez.homezbackend.entity.Estado;
import com.homez.homezbackend.repository.CalificacionPropiedadRepository;
import com.homez.homezbackend.repository.EstadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CalificacionPropiedadService {

    private CalificacionPropiedadRepository calificacionPropiedadRepository;
    ModelMapper modelMapper;


    //Constructor
    @Autowired
    CalificacionPropiedadService(CalificacionPropiedadRepository calificacionPropiedadRepository, ModelMapper modelMapper){
        this.calificacionPropiedadRepository = calificacionPropiedadRepository;
        this.modelMapper = modelMapper;
    }

    public CalificacionPropiedadDTO getCalPropiedad (Integer id) {
        Optional<CalificacionPropiedad> calificacionPropiedadOptional = calificacionPropiedadRepository.findById(id);
        CalificacionPropiedadDTO calificacionPropiedadDTO = null;

        if(calificacionPropiedadOptional.isPresent()){
            CalificacionPropiedad calificacionPropiedad = calificacionPropiedadOptional.get();
            calificacionPropiedadDTO = modelMapper.map(calificacionPropiedad, CalificacionPropiedadDTO.class);

        }

        return  calificacionPropiedadDTO;
    }

    public List<CalificacionPropiedadDTO> getCalPropiedades(){
        List<CalificacionPropiedad> calificacionPropiedads =  (List<CalificacionPropiedad>) calificacionPropiedadRepository.findAll();
        List<CalificacionPropiedadDTO> calificacionPropiedadDTOS = calificacionPropiedads.stream().map(calificacionPropiedad -> modelMapper.map(calificacionPropiedad, CalificacionPropiedadDTO.class)).collect(Collectors.toList());

        return calificacionPropiedadDTOS;
    }

    public CalificacionPropiedadDTO createCalPropiedad(CalificacionPropiedadDTO calificacionPropiedadDTO){
        CalificacionPropiedad calificacionPropiedad = modelMapper.map(calificacionPropiedadDTO, CalificacionPropiedad.class);
        calificacionPropiedad = calificacionPropiedadRepository.save(calificacionPropiedad);

        return modelMapper.map(calificacionPropiedad, CalificacionPropiedadDTO.class);
    }

    public CalificacionPropiedadDTO updateCalPropiedad(CalificacionPropiedadDTO calificacionPropiedadDTO){
        CalificacionPropiedad calificacionPropiedad = modelMapper.map(calificacionPropiedadDTO, CalificacionPropiedad.class);
        calificacionPropiedad = calificacionPropiedadRepository.save(calificacionPropiedad);

        return modelMapper.map(calificacionPropiedad, CalificacionPropiedadDTO.class);
    }

    public void deleteCalPropiedad(Integer id){
        calificacionPropiedadRepository.deleteById(id);
    }

}
