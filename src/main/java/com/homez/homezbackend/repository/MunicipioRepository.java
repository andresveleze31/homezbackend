package com.homez.homezbackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.homez.homezbackend.entity.Municipio;

public interface MunicipioRepository extends CrudRepository<Municipio, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}
