package com.homez.homezbackend.repository;

import com.homez.homezbackend.entity.Solicitud;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SolicitudRepository extends CrudRepository<Solicitud, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
    @Query("SELECT s FROM Solicitud s JOIN s.propiedad p JOIN p.arrendador a WHERE a.id = :propietarioId")
    List<Solicitud> findBySolByPropietarioId(Integer propietarioId);

    @Query("SELECT s FROM Solicitud s WHERE s.arrendatario.id = :arrendatarioId")
    List<Solicitud> findBySolByArrendatarioId(Integer arrendatarioId);
}
