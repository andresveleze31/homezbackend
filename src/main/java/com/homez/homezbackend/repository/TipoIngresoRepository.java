package com.homez.homezbackend.repository;

import com.homez.homezbackend.entity.TipoIngreso;
import org.springframework.data.repository.CrudRepository;

public interface TipoIngresoRepository extends CrudRepository<TipoIngreso, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}
