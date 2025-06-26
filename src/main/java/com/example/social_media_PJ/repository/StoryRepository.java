package com.example.social_media_PJ.repository;

import com.example.social_media_PJ.model.Story;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoryRepository extends JpaRepository<Story, Integer> {
    public List<Story> findStoriesByUserId(Integer userId);
}
