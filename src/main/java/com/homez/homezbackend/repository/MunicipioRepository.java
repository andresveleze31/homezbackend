package com.homez.homezbackend.repository;

import com.homez.homezbackend.entity.Municipio;
import org.springframework.data.repository.CrudRepository;

public interface MunicipioRepository extends CrudRepository<Municipio, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}
