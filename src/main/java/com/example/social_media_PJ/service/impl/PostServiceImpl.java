package com.example.social_media_PJ.service.impl;

import com.example.social_media_PJ.model.Post;
import com.example.social_media_PJ.model.User;
import com.example.social_media_PJ.repository.PostRepository;
import com.example.social_media_PJ.repository.UserRepository;
import com.example.social_media_PJ.service.PostService;
import com.example.social_media_PJ.service.UserService;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    PostRepository postRepository;
    @Autowired
    UserService userService;
    @Autowired
    UserRepository userRepository;

    @Override
    public Post createPost(Post post, Integer userId) throws Exception {
        User user= userService.findUserById(userId);

        Post newPost = new Post();
        newPost.setCation(post.getCation());
        newPost.setImage(post.getImage());
        newPost.setCreatedAt(LocalDateTime.now());
        newPost.setVideo(post.getVideo());
        newPost.setUser(user);

        return postRepository.save(newPost);

    }

    @Override
    public String deletePost(Integer postId, Integer userId) throws Exception {
        Post post = postRepository.findPostByPostId(postId);
        User user = userService.findUserById(userId);
        if(post.getUser().getId().equals(user.getId())){
            postRepository.delete(post);
        }
        throw new Exception("delete post failed");
    }

    @Override
    public List<Post> findAllPostByUserId(Integer userId) throws Exception {
        return postRepository.findPostByUserId(userId);
    }

    @Override
    public Post findPostByPostId(Integer postId) throws Exception {
        Optional<Post> postCheck= postRepository.findById(postId);
        if (postCheck.isPresent()) {
            return postCheck.get();
        }
        throw new Exception("Post not found");
    }

    @Override
    public List<Post> findAllPost() throws Exception {
        return postRepository.findAll();
    }

    @Override
    public Post savePost(Integer postId, Integer userId) throws Exception {
        Post post=postRepository.findPostByPostId(postId);
        User user=userService.findUserById(userId);
        if(user.getSavedPosts().contains(post)){
            user.getSavedPosts().remove(post);
        }
        else user.getSavedPosts().add(post);
        userRepository.save(user);
        return post;
    }

    @Override
    public Post likePost(Integer postId, Integer userId) throws Exception {
        Post post=postRepository.findPostByPostId(postId);
        User user=userService.findUserById(userId);
        if(post.getLiked().contains(user)){
            post.getLiked().remove(user);
        }
        else {
        post.getLiked().add(user);}
        postRepository.save(post);
        return post;

    }
}
