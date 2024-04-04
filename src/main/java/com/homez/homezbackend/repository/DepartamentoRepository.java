package com.homez.homezbackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.homez.homezbackend.entity.Departamento;

public interface DepartamentoRepository extends CrudRepository<Departamento, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}
