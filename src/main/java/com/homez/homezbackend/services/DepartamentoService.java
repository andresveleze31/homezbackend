package com.homez.homezbackend.services;

import com.homez.homezbackend.dto.ArrendatarioDTO;
import com.homez.homezbackend.dto.DepartamentoDTO;
import com.homez.homezbackend.entity.Arrendatario;
import com.homez.homezbackend.entity.Departamento;
import com.homez.homezbackend.repository.ArrendatarioRepository;
import com.homez.homezbackend.repository.DepartamentoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DepartamentoService {

    private DepartamentoRepository departamentoRepository;
    ModelMapper modelMapper;


    //Constructor
    @Autowired
    DepartamentoService(DepartamentoRepository departamentoRepository, ModelMapper modelMapper){
        this.departamentoRepository = departamentoRepository;
        this.modelMapper = modelMapper;
    }

    public DepartamentoDTO getDepartamento (Integer id) {
        Optional<Departamento> departamentoOptional = departamentoRepository.findById(id);
        DepartamentoDTO departamentoDTO = null;

        if(departamentoOptional.isPresent()){
            Departamento departamento = departamentoOptional.get();
            departamentoDTO = modelMapper.map(departamento, DepartamentoDTO.class);

        }

        return  departamentoDTO;
    }

    public List<DepartamentoDTO> getDepartamentos(){
        List<Departamento> departamentos =  (List<Departamento>) departamentoRepository.findAll();
        List<DepartamentoDTO> departamentoDTOS = departamentos.stream().map(departamento -> modelMapper.map(departamento, DepartamentoDTO.class)).collect(Collectors.toList());

        return departamentoDTOS;
    }

    public DepartamentoDTO createDepartamento(DepartamentoDTO departamentoDTO){
        Departamento departamento = modelMapper.map(departamentoDTO, Departamento.class);
        departamento = departamentoRepository.save(departamento);

        return departamentoDTO;
    }

    public DepartamentoDTO updateDepartamento(DepartamentoDTO departamentoDTO){
        Departamento departamento = modelMapper.map(departamentoDTO, Departamento.class);
        departamento = departamentoRepository.save(departamento);

        return departamentoDTO;
    }

    public void deleteDepartamento(Integer id){
        departamentoRepository.deleteById(id);
    }
}
