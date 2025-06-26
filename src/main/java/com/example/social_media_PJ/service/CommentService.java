package com.example.social_media_PJ.service;

import com.example.social_media_PJ.model.Comment;

public interface CommentService {
    public Comment addComment(Comment comment, Integer postId,Integer userId) throws Exception;
    public Comment findCommentById(Integer commentId) throws Exception;
    public Comment likeComment(Integer commentId,Integer userId) throws Exception;

}
