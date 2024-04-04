package com.homez.homezbackend.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.homez.homezbackend.dto.TipoDTO;

@SpringBootTest
public class TipoControllerTest {
    @Autowired
    TipoController tipoController;

    @Test
    void testCreateTipo() {
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");

        int cantidad = tipoController.get().size();
        TipoDTO tipoDTO = new TipoDTO(null, "imgtipo.jpg", "Apart");
        tipoDTO = tipoController.create(tipoDTO);
        int nuevaCantidad = tipoController.get().size();
        assertEquals(cantidad + 1, nuevaCantidad);

    }

    @Test
    void testUpdateTipo() {
        int cantidad = tipoController.get().size();
        TipoDTO tipoDTO = new TipoDTO(null, "imgtipo.jpg", "Apart");

        // Modificamos algunos datos del tipo
        tipoDTO.setTipo("nuevo tipo");

        // Actualizamos el tipo
        TipoDTO updateTipoDTO = tipoController.update(tipoDTO);

        // Verificamos que la actualización fue exitosa
        assertNotNull(updateTipoDTO);
        assertEquals(tipoDTO.getTipo(), updateTipoDTO.getTipo());
    }

    @Test
    void testGetTipoById() {
        // Creamos un tipo para luego actualizarlo
        TipoDTO tipoDTO = new TipoDTO(null, "imgtipo.jpg", "Apart");
        tipoDTO = tipoController.create(tipoDTO);

        // Obtenemos el tipo por su ID
        TipoDTO rTipoDTO = tipoController.get(tipoDTO.getId());

        // Verificamos que el tipo fue encontrado
        assertNotNull(rTipoDTO);
        assertEquals(tipoDTO.getId(), rTipoDTO.getId());
    }

    @Test
    void testDeleteTipo() {
        // Creamos un tipo para luego actualizarlo
        TipoDTO tipoDTO = new TipoDTO(null, "imgtipo.jpg", "Apart");
        tipoDTO = tipoController.create(tipoDTO);

        // Obtenemos la cantidad de tipos antes de borrarlo
        int cantidadAntes = tipoController.get().size();

        // Borramos el tipo
        tipoController.delete(tipoDTO.getId());

        // Obtenemos la cantidad de tipos después de borrarlo
        int cantidadDespues = tipoController.get().size();

        // Verificamos que la cantidad de tipos se haya reducido en 1
        assertEquals(cantidadAntes - 1, cantidadDespues);
    }
}
