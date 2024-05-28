package com.homez.homezbackend.controllers;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.homez.homezbackend.dto.ChatMessageDTO;

@Controller
public class ChatController {

    @MessageMapping("/chat/{roomId}")
    @SendTo("/topic/{roomId}")
    public ChatMessageDTO chat(@DestinationVariable String roomId, ChatMessageDTO message){
        System.out.println(message);
        return new ChatMessageDTO(message.getMessage(), message.getUser());
    }
    
}
