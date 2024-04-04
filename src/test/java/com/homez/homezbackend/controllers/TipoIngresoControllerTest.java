package com.homez.homezbackend.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.homez.homezbackend.dto.TipoIngresoDTO;

@SpringBootTest
class TipoIngresoControllerTest {
    @Autowired
    TipoIngresoController tipoIngresoController;

    @Test
    void testCreateTipo() {
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");

        int cantidad = tipoIngresoController.get().size();
        TipoIngresoDTO tipoIngresoDTO = new TipoIngresoDTO(null, "Ingreso 1");
        tipoIngresoDTO = tipoIngresoController.create(tipoIngresoDTO);
        int nuevaCantidad = tipoIngresoController.get().size();
        assertEquals(cantidad + 1, nuevaCantidad);

    }

    @Test
    void testUpdateTipoIngreso() {
        // Creamos un tipo de ingreso para luego actualizarlo
        TipoIngresoDTO tipoIngresoDTO = new TipoIngresoDTO(null, "Ingreso 1");
        tipoIngresoDTO = tipoIngresoController.create(tipoIngresoDTO);

        // Modificamos algunos datos del tipo de ingreso
        tipoIngresoDTO.setTipoingreso("Nuevo Tipo de Ingreso");

        // Actualizamos el tipo de ingreso
        TipoIngresoDTO updatedTipoIngresoDTO = tipoIngresoController.update(tipoIngresoDTO);

        // Verificamos que la actualización fue exitosa
        assertNotNull(updatedTipoIngresoDTO);
        assertEquals(tipoIngresoDTO.getTipoingreso(), updatedTipoIngresoDTO.getTipoingreso());
    }

    @Test
    void testGetTipoIngresoById() {
        // Creamos un tipo de ingreso para luego actualizarlo
        TipoIngresoDTO tipoIngresoDTO = new TipoIngresoDTO(null, "Ingreso 1");
        tipoIngresoDTO = tipoIngresoController.create(tipoIngresoDTO);

        // Obtenemos el tipo de ingreso por su ID
        TipoIngresoDTO rTipoIngresoDTO = tipoIngresoController.get(tipoIngresoDTO.getId());

        // Verificamos que el tipo de ingreso fue encontrado
        assertNotNull(rTipoIngresoDTO);
        assertEquals(tipoIngresoDTO.getId(), rTipoIngresoDTO.getId());
    }

    @Test
    void testDeleteTipoIngreso() {
        // Creamos un tipo de ingreso para luego actualizarlo
        TipoIngresoDTO tipoIngresoDTO = new TipoIngresoDTO(null, "Ingreso 1");
        tipoIngresoDTO = tipoIngresoController.create(tipoIngresoDTO);

        // Obtenemos la cantidad de tipos de ingreso antes de borrarlo
        int cantidadAntes = tipoIngresoController.get().size();

        // Borramos el tipo de ingreso
        tipoIngresoController.delete(tipoIngresoDTO.getId());

        // Obtenemos la cantidad de tipos de ingreso después de borrarlo
        int cantidadDespues = tipoIngresoController.get().size();

        // Verificamos que la cantidad de tipos de ingreso se haya reducido en 1
        assertEquals(cantidadAntes - 1, cantidadDespues);
    }
}
