package com.homez.homezbackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.homez.homezbackend.entity.Arrendador;

public interface ArrendadorRepository extends CrudRepository<Arrendador, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}