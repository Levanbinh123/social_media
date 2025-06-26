package com.example.social_media_PJ.repository;

import com.example.social_media_PJ.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Post findPostByPostId(Integer postId);
    @Query("select  p from Post p where p.user.id=:userId")
    List<Post> findPostByUserId(Integer userId);
}
