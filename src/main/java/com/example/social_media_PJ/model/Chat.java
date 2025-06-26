package com.example.social_media_PJ.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Chat {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer chatId;
    private String chat_name;
    private String chat_image;
    @ManyToMany(fetch = FetchType.EAGER)
    private List<User> users=new ArrayList<>();
    private LocalDateTime timestamp;
    @OneToMany(mappedBy = "chat")
    private List<Message> messages=new ArrayList<>();
}
