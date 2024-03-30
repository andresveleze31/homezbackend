package com.homez.homezbackend.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TipoIngreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tipoingreso;


    //Relaciones.
    @OneToMany(mappedBy = "tipoIngreso")
    @JsonIgnore
    private List<Propiedad> propiedades = new ArrayList<Propiedad>();

}
