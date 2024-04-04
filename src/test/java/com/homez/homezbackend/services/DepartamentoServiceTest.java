package com.homez.homezbackend.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import com.homez.homezbackend.dto.DepartamentoDTO;
import com.homez.homezbackend.entity.Departamento;
import com.homez.homezbackend.repository.DepartamentoRepository;


class DepartamentoServiceTest {

    @InjectMocks
    private DepartamentoService departamentoService;
    @Mock
    private DepartamentoRepository departamentoRepository;
    @Mock
    private ModelMapper modelMapper;
    private DepartamentoDTO departamentoDTO;
    private Departamento departamento;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        departamentoDTO = new DepartamentoDTO();
        departamentoDTO.setId(1);
        departamentoDTO.setDepartamento("department");
        departamentoDTO.setImg("imgdep.jpg");
        departamento = new Departamento();
        departamento.setId(1);
    }

    @Test
    void testGetById() {
        when(departamentoRepository.findById(1)).thenReturn(Optional.of(departamento));
        when(modelMapper.map(departamento, DepartamentoDTO.class)).thenReturn(departamentoDTO);
        DepartamentoDTO result = departamentoService.getDepartamento(1);
        assertEquals(departamentoDTO, result);
    }

    @Test
    void testGetAll() {
        when(departamentoRepository.findAll()).thenReturn(Arrays.asList(departamento));
        when(modelMapper.map(departamento, DepartamentoDTO.class)).thenReturn(departamentoDTO);
        assertEquals(Arrays.asList(departamentoDTO), departamentoService.getDepartamentos());
    }

    @Test
    void testUpdate() {
        when(departamentoRepository.findById(1)).thenReturn(Optional.of(departamento));
        when(modelMapper.map(departamento, DepartamentoDTO.class)).thenReturn(departamentoDTO);
        when(modelMapper.map(departamentoDTO, Departamento.class)).thenReturn(departamento);
        when(departamentoRepository.save(departamento)).thenReturn(departamento);
        DepartamentoDTO result = departamentoService.updateDepartamento(departamentoDTO);
        assertEquals(departamentoDTO, result);
    }

    @Test
    void testDelete() {
        doNothing().when(departamentoRepository).deleteById(1);
        departamentoService.deleteDepartamento(1);
        verify(departamentoRepository, times(1)).deleteById(1);
    }

}
