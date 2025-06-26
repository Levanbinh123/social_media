package com.example.social_media_PJ.repository;

import com.example.social_media_PJ.model.Chat;
import com.example.social_media_PJ.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChatRepository extends JpaRepository<Chat, Integer> {
    @Query("SELECT c FROM Chat c JOIN c.users u WHERE u.id = :userId")
    public List<Chat> findByUser_Id(@Param("userId") Integer userId);
    @Query("select c from Chat c where  :user MEMBER of c.users and :reqUser MEMBER of c.users")
    public Chat findChatByUsers(@Param("user") User user,@Param("reqUser")User reqUser);

}
