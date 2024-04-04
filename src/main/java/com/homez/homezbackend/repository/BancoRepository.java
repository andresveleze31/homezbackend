package com.homez.homezbackend.repository;

import org.springframework.data.repository.CrudRepository;

import com.homez.homezbackend.entity.Banco;

public interface BancoRepository extends CrudRepository<Banco, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.
}
