package com.homez.homezbackend.repository;

import com.homez.homezbackend.entity.Arrendatario;
import org.springframework.data.repository.CrudRepository;

public interface ArrendatarioRepository extends CrudRepository<Arrendatario, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}