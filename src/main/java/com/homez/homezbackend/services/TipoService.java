package com.homez.homezbackend.services;

import com.homez.homezbackend.dto.TipoDTO;
import com.homez.homezbackend.dto.TipoIngresoDTO;
import com.homez.homezbackend.entity.Tipo;
import com.homez.homezbackend.entity.TipoIngreso;
import com.homez.homezbackend.repository.TipoIngresoRepository;
import com.homez.homezbackend.repository.TipoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoService {

    private TipoRepository tipoRepository;
    ModelMapper modelMapper;


    //Constructor
    @Autowired
    TipoService( TipoRepository tipoRepository, ModelMapper modelMapper){
        this.tipoRepository = tipoRepository;
        this.modelMapper = modelMapper;
    }

    public TipoDTO getTipo (Integer id) {
        Optional<Tipo> tipoOptional = tipoRepository.findById(id);
        TipoDTO tipoDTO = null;

        if(tipoOptional.isPresent()){
            Tipo tipo = tipoOptional.get();
            tipoDTO = modelMapper.map(tipo, TipoDTO.class);

        }

        return  tipoDTO;
    }

    public List<TipoDTO> getAllTipo(){
        List<Tipo> tipos =  (List<Tipo>) tipoRepository.findAll();
        List<TipoDTO> tipoDTOS = tipos.stream().map(tipo -> modelMapper.map(tipo, TipoDTO.class)).collect(Collectors.toList());

        return tipoDTOS;
    }

    public TipoDTO createTipo(TipoDTO tipoDTO){
        Tipo tipo = modelMapper.map(tipoDTO, Tipo.class);
        tipo = tipoRepository.save(tipo);

        return tipoDTO;
    }

    public TipoDTO updateTipo(TipoDTO tipoDTO){
        Tipo tipo = modelMapper.map(tipoDTO, Tipo.class);
        tipo = tipoRepository.save(tipo);

        return tipoDTO;
    }

    public void deleteTipo(Integer id){
        tipoRepository.deleteById(id);
    }
}
