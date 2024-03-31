package com.homez.homezbackend.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

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

    @OneToMany(mappedBy = "arrendatario")
    @JsonIgnore
    private List<Solicitud> solicitudes = new ArrayList<Solicitud>();
}
