package com.homez.homezbackend.dto;

import com.homez.homezbackend.entity.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PropiedadDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean activa;
    private String nombre;
    private String descripcion;
    private Integer personas;
    private Integer habitaciones;
    private Integer baños;
    private Boolean mascotas;
    private Boolean piscina;
    private Boolean asador;
    private Double valor;
    private Integer calificacion;



    private Departamento departamento;


    private Municipio municipio;


    private TipoIngreso tipoIngreso;


    private Arrendador arrendador;


    private Tipo tipo;


}
