package com.homez.homezbackend.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.homez.homezbackend.entity.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudDTO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;
    private Integer personas;
    private Double valor;
    private Integer calificacion;
    private Timestamp createdAt;


    private Pago pago;


    private CalificacionArrendatario calificacionArrendatario;


    private CalificacionPropiedad calificacionPropiedad;


    private Estado estado;


    private Arrendatario arrendatario;


    private Propiedad propiedad;
}
