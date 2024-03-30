package com.homez.homezbackend.services;

import com.homez.homezbackend.dto.FotoDTO;
import com.homez.homezbackend.dto.MunicipioDTO;
import com.homez.homezbackend.entity.Foto;
import com.homez.homezbackend.entity.Municipio;
import com.homez.homezbackend.repository.FotoRepository;
import com.homez.homezbackend.repository.MunicipioRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FotoService {

    private FotoRepository fotoRepository;
    ModelMapper modelMapper;


    //Constructor
    @Autowired
    FotoService( FotoRepository fotoRepository, ModelMapper modelMapper){
        this.fotoRepository = fotoRepository;
        this.modelMapper = modelMapper;
    }

    public FotoDTO getFoto (Integer id) {
        Optional<Foto> fotoOptional = fotoRepository.findById(id);
        FotoDTO fotoDTO = null;

        if(fotoOptional.isPresent()){
            Foto foto = fotoOptional.get();
            fotoDTO = modelMapper.map(foto, FotoDTO.class);

        }

        return  fotoDTO;
    }

    public List<FotoDTO> getFotos(){
        List<Foto> fotos =  (List<Foto>) fotoRepository.findAll();
        List<FotoDTO> fotoDTOS = fotos.stream().map(foto -> modelMapper.map(foto, FotoDTO.class)).collect(Collectors.toList());

        return fotoDTOS;
    }

    public FotoDTO createFoto(FotoDTO fotoDTO){
        Foto foto = modelMapper.map(fotoDTO, Foto.class);
        foto = fotoRepository.save(foto);

        return fotoDTO;
    }

    public FotoDTO updateFoto(FotoDTO fotoDTO){
        Foto foto = modelMapper.map(fotoDTO, Foto.class);
        foto = fotoRepository.save(foto);

        return fotoDTO;
    }

    public void deleteFoto(Integer id){
        fotoRepository.deleteById(id);
    }

}
