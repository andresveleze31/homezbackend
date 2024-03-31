package com.homez.homezbackend.repository;

import com.homez.homezbackend.entity.Solicitud;
import org.springframework.data.repository.CrudRepository;

public interface SolicitudRepository extends CrudRepository<Solicitud, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}
