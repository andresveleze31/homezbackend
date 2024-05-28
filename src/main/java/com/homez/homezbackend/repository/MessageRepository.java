package com.homez.homezbackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.homez.homezbackend.entity.Message;

public interface MessageRepository extends CrudRepository<Message, Integer> {
    // Puedes agregar métodos adicionales según tus necesidades.

    @Query("SELECT m FROM Message m WHERE m.room = :room")
    List<Message> findMessagesByRoom(String room);

}
