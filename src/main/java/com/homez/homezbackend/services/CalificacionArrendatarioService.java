package com.homez.homezbackend.services;

import com.homez.homezbackend.dto.ArrendatarioDTO;
import com.homez.homezbackend.dto.BancoDTO;
import com.homez.homezbackend.dto.CalificacionArrendatarioDTO;
import com.homez.homezbackend.entity.Banco;
import com.homez.homezbackend.entity.CalificacionArrendatario;
import com.homez.homezbackend.repository.BancoRepository;
import com.homez.homezbackend.repository.CalificacionArrendatarioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CalificacionArrendatarioService {

    private CalificacionArrendatarioRepository calificacionArrendatarioRepository;
    ModelMapper modelMapper;


    //Constructor
    @Autowired
    CalificacionArrendatarioService(CalificacionArrendatarioRepository calificacionArrendatarioRepository, ModelMapper modelMapper){
        this.calificacionArrendatarioRepository = calificacionArrendatarioRepository;
        this.modelMapper = modelMapper;
    }

    public CalificacionArrendatarioDTO getCalArrendatario (Integer id) {
        Optional<CalificacionArrendatario> calificacionArrendatarioOptional = calificacionArrendatarioRepository.findById(id);
        CalificacionArrendatarioDTO calificacionArrendatarioDTO = null;

        if(calificacionArrendatarioOptional.isPresent()){
            CalificacionArrendatario calificacionArrendatario = calificacionArrendatarioOptional.get();
            calificacionArrendatarioDTO = modelMapper.map(calificacionArrendatario, CalificacionArrendatarioDTO.class);

        }

        return  calificacionArrendatarioDTO;
    }

    public List<CalificacionArrendatarioDTO> getCalArrendatarios(){
        List<CalificacionArrendatario> calificacionArrendatarios =  (List<CalificacionArrendatario>) calificacionArrendatarioRepository.findAll();
        List<CalificacionArrendatarioDTO> calificacionArrendatarioDTOS = calificacionArrendatarios.stream().map(calificacionArrendatario -> modelMapper.map(calificacionArrendatario, CalificacionArrendatarioDTO.class)).collect(Collectors.toList());

        return calificacionArrendatarioDTOS;
    }

    public CalificacionArrendatarioDTO createCalArrendatario(CalificacionArrendatarioDTO calificacionArrendatarioDTO){
        CalificacionArrendatario calificacionArrendatario = modelMapper.map(calificacionArrendatarioDTO, CalificacionArrendatario.class);
        calificacionArrendatario = calificacionArrendatarioRepository.save(calificacionArrendatario);

        return modelMapper.map(calificacionArrendatario, CalificacionArrendatarioDTO.class);

    }

    public CalificacionArrendatarioDTO updateCalArrendatario(CalificacionArrendatarioDTO calificacionArrendatarioDTO){
        CalificacionArrendatario calificacionArrendatario = modelMapper.map(calificacionArrendatarioDTO, CalificacionArrendatario.class);
        calificacionArrendatario = calificacionArrendatarioRepository.save(calificacionArrendatario);

        return modelMapper.map(calificacionArrendatario, CalificacionArrendatarioDTO.class);
    }

    public void deleteCalArrendatario(Integer id){
        calificacionArrendatarioRepository.deleteById(id);
    }
}
