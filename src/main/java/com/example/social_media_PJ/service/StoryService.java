package com.example.social_media_PJ.service;

import com.example.social_media_PJ.model.Story;
import com.example.social_media_PJ.model.User;

import java.util.List;

public interface StoryService {
    public Story createStory(Story story, User user);
    public List<Story> findStoryByUserId(Integer userId) throws Exception;
}
