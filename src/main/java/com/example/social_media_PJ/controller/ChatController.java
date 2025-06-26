package com.example.social_media_PJ.controller;

import com.example.social_media_PJ.model.Chat;
import com.example.social_media_PJ.model.User;
import com.example.social_media_PJ.model.dtos.CreateRequest;
import com.example.social_media_PJ.service.ChatSerivce;
import com.example.social_media_PJ.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/chat")
public class ChatController {
    @Autowired
    private ChatSerivce chatSerivce;
    @Autowired
    private UserService userService;
    @PostMapping()
    public Chat createChat(@RequestBody CreateRequest createRequest,@RequestHeader("Authorization") String token) throws Exception {
        User reqUser=userService.findUserByToken(token);
        User user=userService.findUserById(reqUser.getId());
        Chat chat = chatSerivce.createChat(reqUser, user);
        return chat;

    }
    @GetMapping()
    public List<Chat> findChatByUserId(@RequestHeader("Authorization")String token) {
        User user = userService.findUserByToken(token);
        return chatSerivce.findChatByUserId(user.getId());
    }
    @GetMapping("/{chatId}")
    private Chat findChatByChatId(@PathVariable Integer chatId) throws Exception {
        Chat chat=chatSerivce.findChatById(chatId);
        return chat;
    }
}
