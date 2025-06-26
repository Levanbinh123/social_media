package com.example.social_media_PJ.service;

import com.example.social_media_PJ.model.Reels;
import com.example.social_media_PJ.model.User;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface ReelsService {
    public Reels createReels(Reels reels, User user) throws Exception;
    public List<Reels> findAllReels();
    public List<Reels> findReelsByUserId(Integer userId) throws Exception;
}
