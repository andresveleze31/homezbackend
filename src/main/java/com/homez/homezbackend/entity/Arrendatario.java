package com.homez.homezbackend.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Arrendatario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String apellido;
    private String correo;
    private Integer telefono;
    private String contraseña;
    private Timestamp createdAt;
}
