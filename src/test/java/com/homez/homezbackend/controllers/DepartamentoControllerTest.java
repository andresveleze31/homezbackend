
package com.homez.homezbackend.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.homez.homezbackend.controllers.DepartamentoController;
import com.homez.homezbackend.dto.DepartamentoDTO;
import com.homez.homezbackend.services.DepartamentoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import org.springframework.http.MediaType;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@SpringBootTest
public class DepartamentoControllerTest {
    @Autowired
    DepartamentoController departamentoController;

    @Test
    void testCreateDepartamento() {
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");

        int cantidad = departamentoController.get().size();
        DepartamentoDTO departamentoDTO = new DepartamentoDTO(null,"img123.jpg" , "Departamento");
        departamentoDTO = departamentoController.create(departamentoDTO);
        int nuevaCantidad = departamentoController.get().size();
        assertEquals(cantidad + 1, nuevaCantidad);

    }

    @Test
    void testUpdateDepartamento() {
        int cantidad = departamentoController.get().size();
        DepartamentoDTO departamentoDTO = new DepartamentoDTO(null, "img123.jpg", "Departamento");

        // Modificamos algunos datos del departamento
        departamentoDTO.setDepartamento("Dep Actualizado");

        // Actualizamos el departamento
        DepartamentoDTO updateDepartamentoDTO = departamentoController.update(departamentoDTO);

        // Verificamos que la actualización fue exitosa
        assertNotNull(updateDepartamentoDTO);
        assertEquals(departamentoDTO.getDepartamento(), updateDepartamentoDTO.getDepartamento());
    }

    @Test
    void testGetDepartamentoById() {
        // Creamos un departamento para luego actualizarlo
        DepartamentoDTO departamentoDTO = new DepartamentoDTO(null, "img123.jpg", "Departamento");
        departamentoDTO = departamentoController.create(departamentoDTO);

        // Obtenemos el departamento por su ID
        DepartamentoDTO rDepartamentoDTO = departamentoController.get(departamentoDTO.getId());

        // Verificamos que el departamento fue encontrado
        assertNotNull(rDepartamentoDTO);
        assertEquals(departamentoDTO.getId(), rDepartamentoDTO.getId());
    }

    @Test
    void testDeleteEstado() {
        // Creamos un departamento para luego actualizarlo
        DepartamentoDTO departamentoDTO = new DepartamentoDTO(null, "img123.jpg", "Departamento");
        departamentoDTO = departamentoController.create(departamentoDTO);

        // Obtenemos la cantidad de departamentos antes de borrarlo
        int cantidadAntes = departamentoController.get().size();

        // Borramos el departamento
        departamentoController.delete(departamentoDTO.getId());

        // Obtenemos la cantidad de departamentos después de borrarlo
        int cantidadDespues = departamentoController.get().size();

        // Verificamos que la cantidad de departamentos se haya reducido en 1
        assertEquals(cantidadAntes - 1, cantidadDespues);
    }
}