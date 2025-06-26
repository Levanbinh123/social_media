package com.example.social_media_PJ.service;

import com.example.social_media_PJ.model.Chat;
import com.example.social_media_PJ.model.User;

import java.util.List;

public interface ChatSerivce {
    public Chat createChat(User reqUser, User user);
    public Chat findChatById(Integer id) throws Exception;
    public List<Chat> findChatByUserId(Integer userId);

}
