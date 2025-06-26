package com.example.social_media_PJ.service;

import com.example.social_media_PJ.model.Chat;
import com.example.social_media_PJ.model.Message;
import com.example.social_media_PJ.model.User;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface MessageService {
    public Message createMessage(User user, Integer chatId, Message req) throws Exception;
    public List<Message> findMessagesByChatId(Integer chatId) throws Exception;
}
