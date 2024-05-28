package com.homez.homezbackend.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.homez.homezbackend.entity.Arrendador;
import com.homez.homezbackend.entity.Arrendatario;

public interface ArrendadorRepository extends CrudRepository<Arrendador, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
    @Query("SELECT a FROM Arrendador a WHERE a.correo = :correo AND a.contraseña = :contrasena")
    Arrendador findArrendatarioByCorreo(String correo, String contrasena);
}