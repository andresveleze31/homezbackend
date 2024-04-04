package com.homez.homezbackend.services;

import com.homez.homezbackend.dto.MunicipioDTO;
import com.homez.homezbackend.dto.SolicitudDTO;
import com.homez.homezbackend.dto.TipoIngresoDTO;
import com.homez.homezbackend.entity.Municipio;
import com.homez.homezbackend.entity.TipoIngreso;
import com.homez.homezbackend.repository.MunicipioRepository;
import com.homez.homezbackend.repository.TipoIngresoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TipoIngresoService {

    private TipoIngresoRepository tipoIngresoRepository;
    ModelMapper modelMapper;


    //Constructor
    @Autowired
    TipoIngresoService( TipoIngresoRepository tipoIngresoRepository, ModelMapper modelMapper){
        this.tipoIngresoRepository = tipoIngresoRepository;
        this.modelMapper = modelMapper;
    }

    public TipoIngresoDTO getTipoIngreso (Integer id) {
        Optional<TipoIngreso> tipoIngresoOptional = tipoIngresoRepository.findById(id);
        TipoIngresoDTO tipoIngresoDTO = null;

        if(tipoIngresoOptional.isPresent()){
            TipoIngreso tipoIngreso = tipoIngresoOptional.get();
            tipoIngresoDTO = modelMapper.map(tipoIngreso, TipoIngresoDTO.class);

        }

        return  tipoIngresoDTO;
    }

    public List<TipoIngresoDTO> getAllTipoIngreso(){
        List<TipoIngreso> tipoIngresos =  (List<TipoIngreso>) tipoIngresoRepository.findAll();
        List<TipoIngresoDTO> tipoIngresoDTOS = tipoIngresos.stream().map(tipoIngreso -> modelMapper.map(tipoIngreso, TipoIngresoDTO.class)).collect(Collectors.toList());

        return tipoIngresoDTOS;
    }

    public TipoIngresoDTO createTipoIngreso(TipoIngresoDTO tipoIngresoDTO){
        TipoIngreso tipoIngreso = modelMapper.map(tipoIngresoDTO, TipoIngreso.class);
        tipoIngreso = tipoIngresoRepository.save(tipoIngreso);

        return modelMapper.map(tipoIngreso, TipoIngresoDTO.class);
    }

    public TipoIngresoDTO updateTipoIngreso(TipoIngresoDTO tipoIngresoDTO){
        TipoIngreso tipoIngreso = modelMapper.map(tipoIngresoDTO, TipoIngreso.class);
        tipoIngreso = tipoIngresoRepository.save(tipoIngreso);

        return modelMapper.map(tipoIngreso, TipoIngresoDTO.class);
    }

    public void deleteTipoIngreso(Integer id){
        tipoIngresoRepository.deleteById(id);
    }
}
