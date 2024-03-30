package com.homez.homezbackend.repository;

import com.homez.homezbackend.entity.Propiedad;
import org.springframework.data.repository.CrudRepository;

public interface PropiedadRepository extends CrudRepository<Propiedad, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}
