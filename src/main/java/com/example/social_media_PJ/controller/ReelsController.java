package com.example.social_media_PJ.controller;

import com.example.social_media_PJ.model.Reels;
import com.example.social_media_PJ.model.User;
import com.example.social_media_PJ.service.ReelsService;
import com.example.social_media_PJ.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reel")
public class ReelsController {
    @Autowired
    private  ReelsService reelsService;
    @Autowired
    private  UserService userService;
        @PostMapping
    public Reels createReels(@RequestBody Reels reels, @RequestHeader("Authorization") String token) throws Exception {
            User user=userService.findUserByToken(token);
            Reels newReels=reelsService.createReels(reels,user);
            return newReels;

        }
        @GetMapping
    public List<Reels> findAllReels() {
            return reelsService.findAllReels();
        }
        @GetMapping("/user/{userId}")
    public List<Reels>findReelsByUserId(@PathVariable Integer userId) throws Exception {
            return reelsService.findReelsByUserId(userId);

        }

}
