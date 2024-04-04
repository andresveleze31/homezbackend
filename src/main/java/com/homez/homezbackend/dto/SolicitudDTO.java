package com.homez.homezbackend.dto;


import java.sql.Timestamp;

import com.homez.homezbackend.entity.Arrendatario;
import com.homez.homezbackend.entity.CalificacionArrendatario;
import com.homez.homezbackend.entity.CalificacionPropiedad;
import com.homez.homezbackend.entity.Estado;
import com.homez.homezbackend.entity.Pago;
import com.homez.homezbackend.entity.Propiedad;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
