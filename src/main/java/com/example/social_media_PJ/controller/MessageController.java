package com.example.social_media_PJ.controller;

import com.example.social_media_PJ.model.Message;
import com.example.social_media_PJ.model.User;
import com.example.social_media_PJ.service.MessageService;
import com.example.social_media_PJ.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/message")
public class MessageController {
@Autowired
    private MessageService messageService;
@Autowired
private UserService userService;
        @PostMapping("/chatMessage/{chatId}")
        public Message createMessage(@RequestHeader("Authorization") String token,
                                     @PathVariable("chatId") Integer chatId,
                                     @RequestBody Message req) throws Exception {
            User reqUser=userService.findUserByToken(token);
            return messageService.createMessage(reqUser,chatId,req);

        }
        @GetMapping("/chatMessage/{chatId}")
    public List<Message> findMessagesByChatId(@PathVariable Integer chatId) throws Exception {
        return messageService.findMessagesByChatId(chatId);
        }
}
