package com.example.social_media_PJ.service;

import com.example.social_media_PJ.model.User;

import java.util.List;

public interface UserService {
    public User addUser(User user);
    public User findUserByEmail(String email);
    public User findUserById(Integer id) throws Exception;
    public User followUser(Integer userId1, Integer userId2) throws Exception;
    public User updateUser(User user,Integer userId) throws Exception;
        public List<User> searchUserByFirstNameOrLastNameOrEmail (String query);
        public User findUserByToken(String token);
}
