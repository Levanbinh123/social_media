package com.example.social_media_PJ.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.annotation.sql.DataSourceDefinitions;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer messageId;
    private String content;
    private String image;
    @ManyToOne
    private User user;
    @ManyToOne
    @JsonIgnore
    private Chat chat;
    private LocalDateTime timestamp;

}
