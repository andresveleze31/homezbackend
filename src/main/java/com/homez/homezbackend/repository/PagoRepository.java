package com.homez.homezbackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.homez.homezbackend.entity.Pago;

public interface PagoRepository extends CrudRepository<Pago, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}

