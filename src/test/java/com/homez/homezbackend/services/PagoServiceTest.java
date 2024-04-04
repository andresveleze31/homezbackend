package com.homez.homezbackend.services;

import com.homez.homezbackend.dto.BancoDTO;
import com.homez.homezbackend.entity.Banco;
import com.homez.homezbackend.repository.BancoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;

import java.util.Arrays;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class PagoServiceTest {
    @InjectMocks
    private BancoService bancoService;
    @Mock
    private BancoRepository bancoRepository;
    @Mock
    private ModelMapper modelMapper;
    private BancoDTO bancoDTO;
    private Banco banco;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        bancoDTO = new BancoDTO();
        bancoDTO.setId(1);
        bancoDTO.setBanco("bank");

        banco = new Banco();
        banco.setId(1);
    }

    @Test
    void testGetById() {
        when(bancoRepository.findById(1)).thenReturn(Optional.of(banco));
        when(modelMapper.map(banco, BancoDTO.class)).thenReturn(bancoDTO);
        BancoDTO result = bancoService.getBanco(1);
        assertEquals(bancoDTO, result);
    }

    @Test
    void testGetAll() {
        when(bancoRepository.findAll()).thenReturn(Arrays.asList(banco));
        when(modelMapper.map(banco, BancoDTO.class)).thenReturn(bancoDTO);
        assertEquals(Arrays.asList(bancoDTO), bancoService.getBancos());
    }

    @Test
    void testUpdate() {
        when(bancoRepository.findById(1)).thenReturn(Optional.of(banco));
        when(modelMapper.map(banco, BancoDTO.class)).thenReturn(bancoDTO);
        when(modelMapper.map(bancoDTO, Banco.class)).thenReturn(banco);
        when(bancoRepository.save(banco)).thenReturn(banco);
        BancoDTO result = bancoService.updateBanco(bancoDTO);
        assertEquals(bancoDTO, result);
    }

    @Test
    void testDelete() {
        doNothing().when(bancoRepository).deleteById(1);
        bancoService.deleteBanco(1);
        verify(bancoRepository, times(1)).deleteById(1);
    }
}
