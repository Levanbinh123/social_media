package com.example.social_media_PJ.controller;

import com.example.social_media_PJ.model.Story;
import com.example.social_media_PJ.model.User;
import com.example.social_media_PJ.service.StoryService;
import com.example.social_media_PJ.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/story")
public class StoryController {
    @Autowired
    private StoryService storyService;
    @Autowired
    private UserService userService;
    @PostMapping
    public Story createStory(
            @RequestBody Story story, @RequestHeader("Authorization") String token) throws Exception {
        User user = userService.findUserByToken(token);
        return storyService.createStory(story, user);

    }
    @GetMapping("/user/{userId}")
    public List<Story> findStoryByUserId(
           @PathVariable Integer userId) throws Exception {
        return storyService.findStoryByUserId(userId);

    }
}
