package com.example.social_media_PJ.controller;

import com.example.social_media_PJ.model.Post;
import com.example.social_media_PJ.model.User;
import com.example.social_media_PJ.response.ApiResponse;
import com.example.social_media_PJ.service.PostService;
import com.example.social_media_PJ.service.UserService;
import jakarta.persistence.Index;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {
    @Autowired
    PostService postService;
    @Autowired
    UserService userService;
    @PostMapping
    public ResponseEntity<Post> createPost(@RequestHeader("Authorization") String token,@RequestBody Post post) throws Exception {
        User reqUser=userService.findUserByToken(token);
        Post addPost= postService.createPost(post,reqUser.getId());
        return ResponseEntity.ok().body(addPost);

    }
    //admin
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Post>> findAllPostByUserId(@PathVariable("userId") Integer userId)throws Exception{
            return ResponseEntity.ok().body(postService.findAllPostByUserId(userId));
    }
    @GetMapping("/{postId}")
    public ResponseEntity<Post> findPostByPostId(@PathVariable("postId") Integer postId)throws Exception{
        return ResponseEntity.ok().body(postService.findPostByPostId(postId));
    }
    @GetMapping
    public ResponseEntity<List<Post>>findAllPost() throws Exception {
        return ResponseEntity.ok().body(postService.findAllPost());
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable Integer postId, @RequestHeader("Authorization") String token) throws Exception {
        User reqUser=userService.findUserByToken(token);
        String message=postService.deletePost(postId,reqUser.getId());
        ApiResponse res= new ApiResponse(message,true);
        return new ResponseEntity<>(res, HttpStatus.OK);
    }
    @PutMapping("/{postId}/user")
    public ResponseEntity<Post> savePostHandler(@PathVariable("postId") Integer postId,@RequestHeader("Authorization") String token)throws Exception{
        User reqUser=userService.findUserByToken(token);
        Post post=postService.savePost(postId,reqUser.getId());
        return ResponseEntity.ok().body(post);
        }

    @PutMapping("/like/{postId}")
    public ResponseEntity<Post> likePostHandler(@PathVariable("postId") Integer postId,@RequestHeader("Authorization") String token)throws Exception{
        User reqUser=userService.findUserByToken(token);
        Post post=postService.likePost(postId, reqUser.getId());
        return ResponseEntity.ok().body(post);
    }



}