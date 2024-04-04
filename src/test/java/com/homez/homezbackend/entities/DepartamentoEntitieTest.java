package com.homez.homezbackend.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import com.homez.homezbackend.entity.Departamento;

public class DepartamentoEntitieTest {
    
    private Departamento departamento;
    @BeforeEach
    void setUp() {
        departamento = new Departamento();
        departamento.setId(1);
        departamento.setImg("img123");
        departamento.setDepartamento("departamento");
        
    }

    @Test
    void testRentAttributes() {
        assertEquals(1, departamento.getId());
        assertEquals("img123", departamento.getImg());
        assertEquals("departamento", departamento.getDepartamento());

    }
}
