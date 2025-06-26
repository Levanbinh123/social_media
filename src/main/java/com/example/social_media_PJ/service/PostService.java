package com.example.social_media_PJ.service;

import com.example.social_media_PJ.model.Post;
import com.example.social_media_PJ.model.User;
import jakarta.persistence.criteria.CriteriaBuilder;

import java.util.List;

public interface PostService {
    Post createPost(Post post, Integer userId)throws Exception;

    String deletePost(Integer postId, Integer userId)throws Exception;
    List<Post> findAllPostByUserId(Integer userId)throws Exception;
    Post findPostByPostId(Integer postId)throws Exception;
    List<Post> findAllPost()throws Exception;
    Post savePost(Integer postId, Integer userId)throws Exception;
    Post likePost(Integer postId, Integer userId)throws Exception;
}
