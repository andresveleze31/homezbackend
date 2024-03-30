package com.homez.homezbackend.repository;

import com.homez.homezbackend.entity.Departamento;
import org.springframework.data.repository.CrudRepository;

public interface DepartamentoRepository extends CrudRepository<Departamento, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}
