package com.homez.homezbackend.repository;

import com.homez.homezbackend.entity.Foto;
import org.springframework.data.repository.CrudRepository;

public interface FotoRepository extends CrudRepository<Foto, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}