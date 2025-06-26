package com.example.social_media_PJ.repository;

import com.example.social_media_PJ.model.Reels;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReelsRepository extends JpaRepository<Reels, Integer> {
    public List<Reels> findReelsByUserId(Integer userId);

}
