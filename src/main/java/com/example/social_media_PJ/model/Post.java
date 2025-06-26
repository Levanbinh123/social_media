package com.example.social_media_PJ.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer postId;
    private String cation;
    private String image;
    private String video;
    @ManyToOne//mot post chi co 1 nguoi dung
    private User user;
    @OneToMany //nhieu nguoi dung co the thich 1 bai post
    private List<User> Liked=new ArrayList<>();
    private LocalDateTime createdAt;
    @OneToMany
    private List<Comment> comments = new ArrayList<>();

}
