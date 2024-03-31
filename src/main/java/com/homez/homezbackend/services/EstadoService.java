package com.homez.homezbackend.services;

import com.homez.homezbackend.dto.BancoDTO;
import com.homez.homezbackend.dto.EstadoDTO;
import com.homez.homezbackend.entity.Banco;
import com.homez.homezbackend.entity.Estado;
import com.homez.homezbackend.repository.BancoRepository;
import com.homez.homezbackend.repository.EstadoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstadoService {

    private EstadoRepository estadoRepository;
    ModelMapper modelMapper;


    //Constructor
    @Autowired
    EstadoService(EstadoRepository estadoRepository, ModelMapper modelMapper){
        this.estadoRepository = estadoRepository;
        this.modelMapper = modelMapper;
    }

    public EstadoDTO getEstado (Integer id) {
        Optional<Estado> estadoOptional = estadoRepository.findById(id);
        EstadoDTO estadoDTO = null;

        if(estadoOptional.isPresent()){
            Estado estado = estadoOptional.get();
            estadoDTO = modelMapper.map(estado, EstadoDTO.class);

        }

        return  estadoDTO;
    }

    public List<EstadoDTO> getEstados(){
        List<Estado> estados =  (List<Estado>) estadoRepository.findAll();
        List<EstadoDTO> estadoDTOS = estados.stream().map(estado -> modelMapper.map(estado, EstadoDTO.class)).collect(Collectors.toList());

        return estadoDTOS;
    }

    public EstadoDTO createEstado(EstadoDTO estadoDTO){
        Estado estado = modelMapper.map(estadoDTO, Estado.class);
        estado = estadoRepository.save(estado);

        return estadoDTO;
    }

    public EstadoDTO updateEstado(EstadoDTO estadoDTO){
        Estado estado = modelMapper.map(estadoDTO, Estado.class);
        estado = estadoRepository.save(estado);

        return estadoDTO;
    }

    public void deleteEstado(Integer id){
        estadoRepository.deleteById(id);
    }

}
