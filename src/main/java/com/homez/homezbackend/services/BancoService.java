package com.homez.homezbackend.services;

import com.homez.homezbackend.dto.BancoDTO;
import com.homez.homezbackend.dto.DepartamentoDTO;
import com.homez.homezbackend.entity.Banco;
import com.homez.homezbackend.entity.Departamento;
import com.homez.homezbackend.repository.BancoRepository;
import com.homez.homezbackend.repository.DepartamentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BancoService {

    private BancoRepository bancoRepository;
    ModelMapper modelMapper;


    //Constructor
    @Autowired
    BancoService(BancoRepository bancoRepository, ModelMapper modelMapper){
        this.bancoRepository = bancoRepository;
        this.modelMapper = modelMapper;
    }

    public BancoDTO getBanco (Integer id) {
        Optional<Banco> bancoOptional = bancoRepository.findById(id);
        BancoDTO bancoDTO = null;

        if(bancoOptional.isPresent()){
            Banco banco = bancoOptional.get();
            bancoDTO = modelMapper.map(banco, BancoDTO.class);

        }

        return  bancoDTO;
    }

    public List<BancoDTO> getBancos(){
        List<Banco> bancos =  (List<Banco>) bancoRepository.findAll();
        List<BancoDTO> bancoDTOS = bancos.stream().map(banco -> modelMapper.map(banco, BancoDTO.class)).collect(Collectors.toList());

        return bancoDTOS;
    }

    public BancoDTO createBanco(BancoDTO bancoDTO){
        Banco banco = modelMapper.map(bancoDTO, Banco.class);
        banco = bancoRepository.save(banco);

        return bancoDTO;
    }

    public BancoDTO updateBanco(BancoDTO bancoDTO){
        Banco banco = modelMapper.map(bancoDTO, Banco.class);
        banco = bancoRepository.save(banco);

        return bancoDTO;
    }

    public void deleteBanco(Integer id){
        bancoRepository.deleteById(id);
    }

}
