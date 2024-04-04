package com.homez.homezbackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.homez.homezbackend.entity.Arrendatario;

public interface ArrendatarioRepository extends CrudRepository<Arrendatario, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}