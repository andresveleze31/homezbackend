package com.homez.homezbackend.repository;

import com.homez.homezbackend.entity.Banco;
import org.springframework.data.repository.CrudRepository;

public interface BancoRepository extends CrudRepository<Banco, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}
