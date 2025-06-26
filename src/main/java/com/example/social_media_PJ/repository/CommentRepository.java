package com.example.social_media_PJ.repository;

import com.example.social_media_PJ.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository  extends JpaRepository<Comment, Integer> {
}
