package com.example.social_media_PJ.service.impl;

import com.example.social_media_PJ.model.Chat;
import com.example.social_media_PJ.model.User;
import com.example.social_media_PJ.repository.ChatRepository;
import com.example.social_media_PJ.service.ChatSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ChatSerivceImpl implements ChatSerivce {
    @Autowired
    private ChatRepository chatRepository;

    @Override
    public Chat createChat(User reqUser, User user) {
        Chat isExist=chatRepository.findChatByUsers(user,reqUser);
        if(isExist!=null){
            return isExist;
        }
        Chat newChat=new Chat();
        newChat.getUsers().add(user);
        newChat.getUsers().add(reqUser);
        newChat.setTimestamp(LocalDateTime.now());
        return chatRepository.save(newChat);
    }

    @Override
    public Chat findChatById(Integer id) throws Exception {
        Optional<Chat> chat=chatRepository.findById(id);
        if(chat.isPresent()){
            return chat.get();
        }
        else {
            throw new Exception("chat not found id-"+chat);
        }
    }

    @Override
    public List<Chat> findChatByUserId(Integer userId) {
        return chatRepository.findByUser_Id(userId);
    }
}
