package com.homez.homezbackend.repository;

import com.homez.homezbackend.entity.Estado;
import org.springframework.data.repository.CrudRepository;

public interface EstadoRepository extends CrudRepository<Estado, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}
