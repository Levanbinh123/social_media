package com.example.social_media_PJ.service.impl;

import com.example.social_media_PJ.model.Reels;
import com.example.social_media_PJ.model.User;
import com.example.social_media_PJ.repository.ReelsRepository;
import com.example.social_media_PJ.repository.UserRepository;
import com.example.social_media_PJ.service.ReelsService;
import com.example.social_media_PJ.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReelsServiceImpl  implements ReelsService {
@Autowired
    private ReelsRepository reelsRepository;
@Autowired
    private  UserService userService;
    @Override
    public Reels createReels(Reels reels, User user) throws Exception {
        Reels newReels = new Reels();
        newReels.setTitle(reels.getTitle());
        newReels.setUser(user);
        newReels.setVideo(reels.getVideo());
        return reelsRepository.save(newReels);
    }

    @Override
    public List<Reels> findAllReels() {
        return reelsRepository.findAll();
    }

    @Override
    public List<Reels> findReelsByUserId(Integer userId) throws Exception {
        User checkUser=userService.findUserById(userId);
        if(checkUser==null){
            throw new Exception("User not found");
        }
        return findReelsByUserId(userId);
    }
}
