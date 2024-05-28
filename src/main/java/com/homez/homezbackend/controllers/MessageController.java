package com.homez.homezbackend.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.homez.homezbackend.dto.MessageDTO;
import com.homez.homezbackend.dto.MunicipioDTO;
import com.homez.homezbackend.services.MessageService;

@RestController
@RequestMapping("/api/homez/message")
public class MessageController {
    
    MessageService messageService;

    @Autowired
    public MessageController( MessageService messageService){
        this.messageService = messageService;

    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageDTO create(@RequestBody MessageDTO messageDTO) {
        return messageService.create(messageDTO);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MessageDTO> get(@PathVariable String id){
        return messageService.getMessageByRoom(id);
    }
}
