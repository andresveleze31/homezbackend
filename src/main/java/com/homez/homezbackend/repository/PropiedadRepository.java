package com.homez.homezbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.homez.homezbackend.entity.Propiedad;

public interface PropiedadRepository extends CrudRepository<Propiedad, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.

    @Query("SELECT p FROM Propiedad p WHERE p.arrendador.id = :propietarioId")
    List<Propiedad> findByPropietarioId(Integer propietarioId);
}
