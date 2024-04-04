package com.homez.homezbackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.homez.homezbackend.entity.Foto;

public interface FotoRepository extends CrudRepository<Foto, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}