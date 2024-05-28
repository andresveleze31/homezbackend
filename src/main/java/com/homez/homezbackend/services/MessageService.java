package com.homez.homezbackend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homez.homezbackend.dto.MessageDTO;
import com.homez.homezbackend.entity.Message;
import com.homez.homezbackend.repository.MessageRepository;

@Service
public class MessageService {
    private MessageRepository messageRepository;
    ModelMapper modelMapper;


    //Constructor
    @Autowired
    MessageService(MessageRepository messageRepository, ModelMapper modelMapper){
        this.messageRepository = messageRepository;
        this.modelMapper = modelMapper;
    }

    public MessageDTO create(MessageDTO messageDTO){
        Message message = modelMapper.map(messageDTO, Message.class);
        message = messageRepository.save(message);
        return modelMapper.map(message, MessageDTO.class);
    }

    public List<MessageDTO> getMessageByRoom(String room) {
        List<Message> messages = (List<Message>) messageRepository.findMessagesByRoom(room);
        List<MessageDTO> messageDTOs = messages.stream()
                .map(message -> modelMapper.map(message, MessageDTO.class)).collect(Collectors.toList());

        return messageDTOs;
    }
}
