package com.homez.homezbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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
