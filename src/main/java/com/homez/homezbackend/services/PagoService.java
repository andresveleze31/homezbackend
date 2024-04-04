package com.homez.homezbackend.services;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homez.homezbackend.dto.PagoDTO;
import com.homez.homezbackend.entity.Pago;
import com.homez.homezbackend.repository.PagoRepository;

@Service
public class PagoService {

    private PagoRepository pagoRepository;
    ModelMapper modelMapper;


    //Constructor
    @Autowired
    PagoService(PagoRepository pagoRepository, ModelMapper modelMapper){
        this.pagoRepository = pagoRepository;
        this.modelMapper = modelMapper;
    }

    public PagoDTO getPago (Integer id) {
        Optional<Pago> pagoOptional = pagoRepository.findById(id);
        PagoDTO pagoDTO = null;

        if(pagoOptional.isPresent()){
            Pago pago = pagoOptional.get();
            pagoDTO = modelMapper.map(pago, PagoDTO.class);

        }

        return  pagoDTO;
    }

    public List<PagoDTO> getPagos(){
        List<Pago> pagos =  (List<Pago>) pagoRepository.findAll();
        List<PagoDTO> pagoDTOS = pagos.stream().map(pago -> modelMapper.map(pago, PagoDTO.class)).collect(Collectors.toList());

        return pagoDTOS;
    }

    public PagoDTO createPago(PagoDTO pagoDTO){
        Pago pago = modelMapper.map(pagoDTO, Pago.class);
        pago = pagoRepository.save(pago);

        return modelMapper.map(pago, PagoDTO.class);

    }

    public PagoDTO updatePago(PagoDTO pagoDTO){
        Pago pago = modelMapper.map(pagoDTO, Pago.class);
        pago = pagoRepository.save(pago);

        return modelMapper.map(pago, PagoDTO.class);
    }

    public void deletePago(Integer id){
        pagoRepository.deleteById(id);
    }

}
