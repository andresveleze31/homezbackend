package com.homez.homezbackend.repository;

import com.homez.homezbackend.entity.Tipo;
import org.springframework.data.repository.CrudRepository;

public interface TipoRepository extends CrudRepository<Tipo, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}
