package com.example.social_media_PJ.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Story {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer storyId;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    private String image;
    private String caption;
    private LocalDateTime timestamp;
}
