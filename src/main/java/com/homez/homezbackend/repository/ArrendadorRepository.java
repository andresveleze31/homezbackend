package com.homez.homezbackend.repository;

import com.homez.homezbackend.entity.Arrendador;
import org.springframework.data.repository.CrudRepository;

public interface ArrendadorRepository extends CrudRepository<Arrendador, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}