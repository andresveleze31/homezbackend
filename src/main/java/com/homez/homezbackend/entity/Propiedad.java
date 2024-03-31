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
public class Propiedad {

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


    //Relaciones
    @ManyToOne
    @JoinColumn(name = "id_departamento", referencedColumnName = "id", nullable = false, unique = false)
    @JsonIgnore
    private Departamento departamento;

    @ManyToOne
    @JoinColumn(name = "id_municipio", referencedColumnName = "id", nullable = false, unique = false)
    @JsonIgnore
    private Municipio municipio;

    @ManyToOne
    @JoinColumn(name = "id_tipo_ingreso", referencedColumnName = "id", nullable = false, unique = false)
    @JsonIgnore
    private TipoIngreso tipoIngreso;

    @ManyToOne
    @JoinColumn(name = "id_arrendador", referencedColumnName = "id", nullable = false, unique = false)
    @JsonIgnore
    private Arrendador arrendador;

    @ManyToOne
    @JoinColumn(name = "id_tipo", referencedColumnName = "id", nullable = false, unique = false)
    @JsonIgnore
    private Tipo tipo;

    @OneToMany(mappedBy = "propiedad")
    @JsonIgnore
    private List<Foto> fotos = new ArrayList<Foto>();

    @OneToMany(mappedBy = "propiedad")
    @JsonIgnore
    private List<Solicitud> solicitudes = new ArrayList<Solicitud>();



}
