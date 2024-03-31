package com.homez.homezbackend.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.homez.homezbackend.entity.Banco;
import com.homez.homezbackend.entity.Pago;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagoDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Float valor;
    private Integer numeroCuenta;



    private Banco banco;

}
