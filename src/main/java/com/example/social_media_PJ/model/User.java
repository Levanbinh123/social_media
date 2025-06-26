package com.example.social_media_PJ.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @ElementCollection
    private List<Integer> followers =new ArrayList<>();
    @ElementCollection
    private List<Integer> following =new ArrayList<>();
    private String gender;
    @ManyToMany
    private List<Post> savedPosts=new ArrayList<>();


}
