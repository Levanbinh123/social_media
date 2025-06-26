package com.example.social_media_PJ.service.impl;

import com.example.social_media_PJ.model.Comment;
import com.example.social_media_PJ.model.Post;
import com.example.social_media_PJ.model.User;
import com.example.social_media_PJ.repository.CommentRepository;
import com.example.social_media_PJ.repository.PostRepository;
import com.example.social_media_PJ.service.CommentService;
import com.example.social_media_PJ.service.PostService;
import com.example.social_media_PJ.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service

public class CommentServiceImpl implements CommentService {
    @Autowired
    private  CommentRepository commentRepository;
    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;
    @Autowired
    private PostRepository postRepository;

    @Override
    public Comment addComment(Comment comment, Integer postId, Integer userId) throws Exception {
        User user=userService.findUserById(userId);
        Post post=postService.findPostByPostId(postId);
        comment.setUser(user);
        comment.setContent(comment.getContent());
        comment.setCreatedAt(LocalDateTime.now());
        Comment newComment=commentRepository.save(comment);
        post.getComments().add(newComment);
        postRepository.save(post);
        return newComment;

    }

    @Override
    public Comment findCommentById(Integer commentId) throws Exception {
        Optional<Comment> opt= Optional.ofNullable(commentRepository.findById(commentId).orElse(null));
        if(!opt.isPresent()){
            throw  new Exception("Comment not found");

        }
        return opt.get();
    }

    @Override
    public Comment likeComment(Integer commentId, Integer userId) throws Exception {
       Comment comment= findCommentById(commentId);
        User user=userService.findUserById(userId);
        if(!comment.getLiked().contains(user)){
            comment.getLiked().add(user);
        }
        else comment.getLiked().remove(user);
        return commentRepository.save(comment);
    }
}
