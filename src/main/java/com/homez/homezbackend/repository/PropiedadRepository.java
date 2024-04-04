package com.homez.homezbackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.homez.homezbackend.entity.Propiedad;

public interface PropiedadRepository extends CrudRepository<Propiedad, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}
