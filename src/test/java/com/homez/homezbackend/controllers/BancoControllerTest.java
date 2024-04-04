package com.homez.homezbackend.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.homez.homezbackend.dto.BancoDTO;
import com.homez.homezbackend.dto.MunicipioDTO;

@SpringBootTest
public class BancoControllerTest {
    @Autowired
    BancoController bancoController;

    @Test
    void testCreateBanco(){
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");
        System.out.println("-----------------------");

        int cantidad = bancoController.get().size();
        BancoDTO bancoDTO = new BancoDTO(null, "Banco");
        bancoDTO = bancoController.create(bancoDTO);
        int nuevaCantidad = bancoController.get().size();
        assertEquals(cantidad + 1, nuevaCantidad);

    }

    @Test
    void testUpdateBanco() {
        // Creamos un banco para luego actualizarlo
        BancoDTO bancoDTO = new BancoDTO(null, "Banco");
        bancoDTO = bancoController.create(bancoDTO);

        // Modificamos algunos datos del banco
        bancoDTO.setBanco("Banco Actualizado");

        // Actualizamos el banco
        BancoDTO updatedBancoDTO = bancoController.update(bancoDTO);

        // Verificamos que la actualización fue exitosa
        assertNotNull(updatedBancoDTO);
        assertEquals(bancoDTO.getBanco(), updatedBancoDTO.getBanco());
    }

    @Test
    void testGetBancoById() {
        // Creamos un banco para luego actualizarlo
        BancoDTO bancoDTO = new BancoDTO(null, "Banco");
        bancoDTO = bancoController.create(bancoDTO);

        // Obtenemos el banco por su ID
        BancoDTO rBancoDTO = bancoController.get(bancoDTO.getId());

        // Verificamos que el banco fue encontrado
        assertNotNull(rBancoDTO);
        assertEquals(bancoDTO.getId(), rBancoDTO.getId());
    }

    @Test
    void testDeleteBanco() {
        // Creamos un banco para luego actualizarlo
        BancoDTO bancoDTO = new BancoDTO(null, "Banco");
        bancoDTO = bancoController.create(bancoDTO);

        // Obtenemos la cantidad de bancos antes de borrarlo
        int cantidadAntes = bancoController.get().size();

        // Borramos el banco
        bancoController.delete(bancoDTO.getId());

        // Obtenemos la cantidad de bancos después de borrarlo
        int cantidadDespues = bancoController.get().size();

        // Verificamos que la cantidad de bancos se haya reducido en 1
        assertEquals(cantidadAntes - 1, cantidadDespues);
    }
}
