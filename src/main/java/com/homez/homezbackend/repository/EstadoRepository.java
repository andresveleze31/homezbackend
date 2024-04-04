package com.homez.homezbackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.homez.homezbackend.entity.Estado;

public interface EstadoRepository extends CrudRepository<Estado, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}
