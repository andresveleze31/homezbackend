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
public class Solicitud {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Timestamp fechaInicio;
    private Timestamp fechaFin;
    private Integer personas;
    private Double valor;
    private Integer calificacion;
    private Timestamp createdAt;

    @OneToOne(optional = true)
    @JoinColumn(name = "id_pago")
    @JsonIgnore
    private Pago pago;


    @OneToOne(optional = true)
    @JoinColumn(name = "id_calificacion_arrendatario")
    @JsonIgnore
    private CalificacionArrendatario calificacionArrendatario;

    @OneToOne(optional = true)
    @JoinColumn(name = "id_calificacion_propiedad")
    @JsonIgnore
    private CalificacionPropiedad calificacionPropiedad;

    @ManyToOne
    @JoinColumn(name = "id_estado", referencedColumnName = "id", nullable = false, unique = false)
    @JsonIgnore
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "id_arrendatario", referencedColumnName = "id", nullable = false, unique = false)
    @JsonIgnore
    private Arrendatario arrendatario;

    @ManyToOne
    @JoinColumn(name = "id_propiedad", referencedColumnName = "id", nullable = false, unique = false)
    @JsonIgnore
    private Propiedad propiedad;


}
