package com.homez.homezbackend.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homez.homezbackend.dto.SolicitudDTO;
import com.homez.homezbackend.entity.Solicitud;
import com.homez.homezbackend.repository.SolicitudRepository;

@Service
public class SolicitudService {

    private SolicitudRepository solicitudRepository;
    ModelMapper modelMapper;


    //Constructor
    @Autowired
    SolicitudService(SolicitudRepository solicitudRepository, ModelMapper modelMapper){
        this.solicitudRepository = solicitudRepository;
        this.modelMapper = modelMapper;
    }

    public SolicitudDTO getSolicitud (Integer id) {
        Optional<Solicitud> solicitudOptional = solicitudRepository.findById(id);
        SolicitudDTO solicitudDTO = null;

        if(solicitudOptional.isPresent()){
            Solicitud solicitud = solicitudOptional.get();
            solicitudDTO = modelMapper.map(solicitud, SolicitudDTO.class);

        }

        return  solicitudDTO;
    }

    public List<SolicitudDTO> getAllSolicitudes(){
        List<Solicitud> solicituds =  (List<Solicitud>) solicitudRepository.findAll();
        List<SolicitudDTO> solicitudDTOS = solicituds.stream().map(solicitud -> modelMapper.map(solicitud, SolicitudDTO.class)).collect(Collectors.toList());

        return solicitudDTOS;
    }

    public SolicitudDTO createSolicitud(SolicitudDTO solicitudDTO){
        Solicitud solicitud = modelMapper.map(solicitudDTO, Solicitud.class);
        solicitud = solicitudRepository.save(solicitud);

        return modelMapper.map(solicitud, SolicitudDTO.class);
    }

    public SolicitudDTO updateSolicitud(SolicitudDTO solicitudDTO){
        Solicitud solicitud = modelMapper.map(solicitudDTO, Solicitud.class);
        solicitud = solicitudRepository.save(solicitud);

        return modelMapper.map(solicitud, SolicitudDTO.class);
    }

    public void deleteSolicitud(Integer id){
        solicitudRepository.deleteById(id);
    }
}
