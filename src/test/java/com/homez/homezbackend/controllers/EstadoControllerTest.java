package com.homez.homezbackend.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.homez.homezbackend.controllers.EstadoController;
import com.homez.homezbackend.dto.EstadoDTO;

@SpringBootTest
public class EstadoControllerTest {

    @Autowired
    EstadoController estadoController;

    @Test
    void testCreateEstado(){
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");

        int cantidad = estadoController.get().size();
        EstadoDTO estadoDTO = new EstadoDTO(null, "Muy Activo");
        estadoDTO = estadoController.create(estadoDTO);
        int nuevaCantidad = estadoController.get().size();
        assertEquals(cantidad + 1, nuevaCantidad);

    }

    @Test
    void testUpdateEstado(){
        // Creamos un departamento para luego actualizarlo
        EstadoDTO estadoDTO = new EstadoDTO(null,"Muy Activo");
        estadoDTO = estadoController.create(estadoDTO);

        // Modificamos algunos datos del departamento
        estadoDTO.setEstado("Estado Actualizado");

        // Actualizamos el departamento
        EstadoDTO updatedEstadoDTO = estadoController.update(estadoDTO);

        // Verificamos que la actualización fue exitosa
        assertNotNull(updatedEstadoDTO);
        assertEquals(estadoDTO.getEstado(), updatedEstadoDTO.getEstado());
    }

    @Test
    void testGetEstadoById(){
        // Creamos un departamento para luego obtenerlo por su ID
        EstadoDTO estadoDTO = new EstadoDTO(null, "Muy Activo");
        estadoDTO = estadoController.create(estadoDTO);

        // Obtenemos el departamento por su ID
        EstadoDTO rEstadoDTO = estadoController.get(estadoDTO.getId());

        // Verificamos que el departamento fue encontrado
        assertNotNull(rEstadoDTO);
        assertEquals(estadoDTO.getId(), rEstadoDTO.getId());
    }

    @Test
    void testDeleteEstado(){
        // Creamos un departamento para luego borrarlo
        EstadoDTO estadoDTO = new EstadoDTO(null, "Muy Activo");
        estadoDTO = estadoController.create(estadoDTO);

        // Obtenemos la cantidad de departamentos antes de borrarlo
        int cantidadAntes = estadoController.get().size();

        // Borramos el departamento
        estadoController.delete(estadoDTO.getId());

        // Obtenemos la cantidad de departamentos después de borrarlo
        int cantidadDespues = estadoController.get().size();

        // Verificamos que la cantidad de departamentos se haya reducido en 1
        assertEquals(cantidadAntes - 1, cantidadDespues);
    }

    
    
}
