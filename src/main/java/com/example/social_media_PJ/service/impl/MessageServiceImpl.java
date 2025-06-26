package com.example.social_media_PJ.service.impl;

import com.example.social_media_PJ.model.Chat;
import com.example.social_media_PJ.model.Message;
import com.example.social_media_PJ.model.User;
import com.example.social_media_PJ.repository.ChatRepository;
import com.example.social_media_PJ.repository.MessageRepository;
import com.example.social_media_PJ.service.ChatSerivce;
import com.example.social_media_PJ.service.MessageService;
import com.example.social_media_PJ.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private UserService userService;
    @Autowired
    private MessageRepository messageRepository;
    @Autowired
    private ChatSerivce chatSerivce;
    @Autowired
    private ChatRepository chatRepository;
    @Override
    public Message createMessage(User user, Integer chatId, Message req) throws Exception {
        Message message = new Message();
        Chat chat =chatSerivce.findChatById(chatId);
        message.setChat(chat);
        message.setContent(req.getContent());
        message.setImage(req.getImage());
        message.setUser(user);
        message.setTimestamp(LocalDateTime.now());
        Message SaveMessage= messageRepository.save(message);
        chat.getMessages().add(SaveMessage);
        Chat updateChat=chatRepository.saveAndFlush(chat);
        return SaveMessage;

    }

    @Override
    public List<Message> findMessagesByChatId(Integer chatId) throws Exception {

        Chat chat =chatSerivce.findChatById(chatId);
        if(chat==null){
            throw new Exception("chat not found");
        }
        return messageRepository.findByChat_ChatId(chatId);
    }
}
