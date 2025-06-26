package com.example.social_media_PJ.repository;

import com.example.social_media_PJ.model.Message;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Integer> {
    public List<Message> findByChat_ChatId(Integer chatId);
}
