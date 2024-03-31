package com.homez.homezbackend.repository;

import com.homez.homezbackend.entity.Pago;
import org.springframework.data.repository.CrudRepository;

public interface PagoRepository extends CrudRepository<Pago, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}

