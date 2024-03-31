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
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float valor;
    private Integer numeroCuenta;

    //Relaciones
    @ManyToOne
    @JoinColumn(name = "id_pago", referencedColumnName = "id", nullable = false, unique = false)
    @JsonIgnore
    private Banco banco;

    @OneToOne(mappedBy = "pago", cascade = CascadeType.ALL)
    @JsonIgnore
    private Solicitud solicitud;




}
