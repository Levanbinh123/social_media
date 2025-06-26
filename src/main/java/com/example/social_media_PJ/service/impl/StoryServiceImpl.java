package com.example.social_media_PJ.service.impl;

import com.example.social_media_PJ.model.Story;
import com.example.social_media_PJ.model.User;
import com.example.social_media_PJ.repository.StoryRepository;
import com.example.social_media_PJ.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StoryServiceImpl implements StoryService {
    @Autowired
    private StoryRepository storyRepository;

    @Override
    public Story createStory(Story story, User user) {
        Story newStory = new Story();
        newStory.setUser(user);
        newStory.setImage(story.getImage());
        newStory.setCaption(story.getCaption());
        newStory.setTimestamp(LocalDateTime.now());
        return storyRepository.save(newStory);

    }

    @Override
    public List<Story> findStoryByUserId(Integer userId) throws Exception {
        List<Story> stories= storyRepository.findStoriesByUserId(userId);
        if(stories==null){
            throw new Exception("this user have not story");
        }
        return stories;
    }
}
