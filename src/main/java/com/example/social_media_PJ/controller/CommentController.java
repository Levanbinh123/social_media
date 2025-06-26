package com.example.social_media_PJ.controller;

import com.example.social_media_PJ.model.Comment;
import com.example.social_media_PJ.model.User;
import com.example.social_media_PJ.repository.CommentRepository;
import com.example.social_media_PJ.service.CommentService;
import com.example.social_media_PJ.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final CommentRepository commentRepository;
    private final UserService userService;
    @PostMapping("/post/{postId}")
    public Comment createComment(@RequestBody Comment comment,
                                 @PathVariable Integer postId,
                                 @RequestHeader("Authorization") String token) throws Exception {
        User user=userService.findUserByToken(token);
        Comment saveComment=commentService.addComment(comment,postId,user.getId());
        return saveComment;

    }

    @GetMapping ("/{commentId}")
    public Comment findCommentById(@PathVariable Integer commentId) throws Exception {
        return commentService.findCommentById(commentId);

    }
    @PutMapping("/like/{commentId}")
    public Comment likeComment(@PathVariable Integer commentId, @RequestHeader("Authorization") String token) throws Exception {
        User user=userService.findUserByToken(token);
        return commentService.likeComment(commentId, user.getId());
    }
}
