package com.homez.homezbackend.repository;

import com.homez.homezbackend.entity.CalificacionArrendatario;
import com.homez.homezbackend.entity.Departamento;
import org.springframework.data.repository.CrudRepository;

public interface CalificacionArrendatarioRepository extends CrudRepository<CalificacionArrendatario, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}
