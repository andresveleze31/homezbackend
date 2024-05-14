package com.homez.homezbackend.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.homez.homezbackend.entity.Arrendatario;

public interface ArrendatarioRepository extends CrudRepository<Arrendatario, Integer> {
    
    @Query("SELECT a FROM Arrendatario a WHERE a.correo = :correo AND a.contraseña = :contrasena")
    Arrendatario findArrendatarioByCorreo(String correo, String contrasena);

}