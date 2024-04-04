package com.homez.homezbackend.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import com.homez.homezbackend.dto.MunicipioDTO;

@SpringBootTest
public class MunicipioControllerTest {
    @Autowired
    MunicipioController municipioController;

    @Test
    void testCreateMunicipio(){
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");

        int cantidad = municipioController.get().size();
        MunicipioDTO municipioDTO = new MunicipioDTO(null, "Municipio");
        municipioDTO = municipioController.create(municipioDTO);
        int nuevaCantidad = municipioController.get().size();
        assertEquals(cantidad + 1, nuevaCantidad);

    }

    @Test
    void testUpdateMunicipio(){
        // Creamos un departamento para luego actualizarlo
        MunicipioDTO municipioDTO = new MunicipioDTO(null,"Muy Activo");
        municipioDTO = municipioController.create(municipioDTO);

        // Modificamos algunos datos del departamento
        municipioDTO.setMunicipio("Municipio Actualizado");

        // Actualizamos el departamento
        MunicipioDTO updatedMunicipioDTO = municipioController.update(municipioDTO);

        // Verificamos que la actualización fue exitosa
        assertNotNull(updatedMunicipioDTO);
        assertEquals(municipioDTO.getMunicipio(), updatedMunicipioDTO.getMunicipio());
    }

    @Test
    void testGetEstadoById(){
        // Creamos un departamento para luego actualizarlo
        MunicipioDTO municipioDTO = new MunicipioDTO(null,"Muy Activo");
        municipioDTO = municipioController.create(municipioDTO);

        // Obtenemos el departamento por su ID
        MunicipioDTO rMunicipioDTO = municipioController.get(municipioDTO.getId());

        // Verificamos que el departamento fue encontrado
        assertNotNull(rMunicipioDTO);
        assertEquals(municipioDTO.getId(), rMunicipioDTO.getId());
    }

    @Test
    void testDeleteEstado(){
        // Creamos un departamento para luego actualizarlo
        MunicipioDTO municipioDTO = new MunicipioDTO(null,"Muy Activo");
        municipioDTO = municipioController.create(municipioDTO);

        // Obtenemos la cantidad de departamentos antes de borrarlo
        int cantidadAntes = municipioController.get().size();

        // Borramos el departamento
        municipioController.delete(municipioDTO.getId());

        // Obtenemos la cantidad de departamentos después de borrarlo
        int cantidadDespues = municipioController.get().size();

        // Verificamos que la cantidad de departamentos se haya reducido en 1
        assertEquals(cantidadAntes - 1, cantidadDespues);
    }
}
