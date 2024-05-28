package com.homez.homezbackend.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.sql.Timestamp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.homez.homezbackend.dto.ArrendadorDTO;

@SpringBootTest
class ArrendadorControllerTest {
    @Autowired
    ArrendadorController arrendadorController;

    @Test
    void testCreateArrendador() {
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");

        int cantidad = arrendadorController.get().size();
        ArrendadorDTO arrendadorDTO = new ArrendadorDTO(
                null, // id
                "Juan", // nombre
                "Pérez", // apellido
                "juan@example.com", // correo
                123456789, // teléfono
                "Password123", // contraseña
                new Timestamp(System.currentTimeMillis()) // createdAt
        );
        arrendadorDTO = arrendadorController.create(arrendadorDTO);
        int nuevaCantidad = arrendadorController.get().size();
        assertEquals(cantidad + 1, nuevaCantidad);

    }

    @Test
    void testUpdateArrendador() {
        // Creamos un arrendador para luego actualizarlo
        ArrendadorDTO arrendadorDTO = new ArrendadorDTO(
                null, // id
                "Juan", // nombre
                "Pérez", // apellido
                "juan@example.com", // correo
                123456789, // teléfono
                "Password123", // contraseña
                new Timestamp(System.currentTimeMillis()) // createdAt
        );
        arrendadorDTO = arrendadorController.create(arrendadorDTO);

        // Modificamos algunos datos del arrendador
        arrendadorDTO.setNombre("Juanito");

        // Actualizamos el arrendador
        ArrendadorDTO updatedArrendadorDTO = arrendadorController.update(arrendadorDTO);

        // Verificamos que la actualización fue exitosa
        assertNotNull(updatedArrendadorDTO);
        assertEquals(arrendadorDTO.getNombre(), updatedArrendadorDTO.getNombre());
    }

    @Test
    void testGetArrendadorById() {
        // Creamos un arrendador para luego obtenerlo por su ID
        ArrendadorDTO arrendadorDTO = new ArrendadorDTO(
                null, // id
                "Juan", // nombre
                "Pérez", // apellido
                "juan@example.com", // correo
                123456789, // teléfono
                "Password123", // contraseña
                new Timestamp(System.currentTimeMillis()) // createdAt
        );
        arrendadorDTO = arrendadorController.create(arrendadorDTO);

        // Obtenemos el arrendador por su ID

    }

    @Test
    void testDeleteArrendador() {
        // Creamos un arrendador para luego borrarlo
        ArrendadorDTO arrendadorDTO = new ArrendadorDTO(
                null, // id
                "Juan", // nombre
                "Pérez", // apellido
                "juan@example.com", // correo
                123456789, // teléfono
                "Password123", // contraseña
                new Timestamp(System.currentTimeMillis()) // createdAt
        );
        arrendadorDTO = arrendadorController.create(arrendadorDTO);

        // Obtenemos la cantidad de arrendadores antes de borrarlo
        int cantidadAntes = arrendadorController.get().size();

        // Borramos el arrendador
        arrendadorController.delete(arrendadorDTO.getId());

        // Obtenemos la cantidad de arrendadores después de borrarlo
        int cantidadDespues = arrendadorController.get().size();

        // Verificamos que la cantidad de arrendadores se haya reducido en 1
        assertEquals(cantidadAntes - 1, cantidadDespues);
    }
}
