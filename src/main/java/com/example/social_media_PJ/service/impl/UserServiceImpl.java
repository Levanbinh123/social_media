package com.example.social_media_PJ.service.impl;

import com.example.social_media_PJ.config.JwtProvider;
import com.example.social_media_PJ.model.User;
import com.example.social_media_PJ.repository.UserRepository;
import com.example.social_media_PJ.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private  UserRepository userRepository;

    @Override
    public User addUser(User user) {
        // Khởi tạo mới để tránh lỗi khi client cố set ID
        User newUser = new User();
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword()); // hoặc mã hóa
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setGender(user.getGender());
        newUser= userRepository.save(newUser);
        return newUser;
    }

    @Override
    public User findUserByEmail(String email) {
    User user=userRepository.findByEmail(email);
    return user;
    }

    @Override
    public User findUserById(Integer id) throws Exception{
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            return user.get();
        }
        throw new Exception("user not exist with this userId: "+id);
    }

    @Override
    public User followUser(Integer reqUserId, Integer userId2) throws Exception {
        User reqUser=findUserById(reqUserId);
        User user2=findUserById(userId2);
        user2.getFollowers().add(reqUser.getId());
        reqUser.getFollowing().add(user2.getId());
        userRepository.save(reqUser);
        userRepository.save(user2);
        return reqUser;
    }

    @Override
    public User updateUser(User user,Integer userId) throws Exception {
        Optional<User> user1 = userRepository.findById(userId);
        if(!user1.isPresent()){
            throw new Exception("not found id to updateUser");

        }
        User newUser = new User();
        if(user.getFirstName()!=null){
            newUser.setFirstName(user.getFirstName());
        }
        if(user.getLastName()!=null){
            newUser.setLastName(user.getLastName());
        }
        if(user.getEmail()!=null){
            newUser.setEmail(user.getEmail());
        }
        if(user.getPassword()!=null){
            newUser.setPassword(user.getPassword());
        }
        if(user.getGender()!=null){
            newUser.setGender(user.getGender());
        }
        return userRepository.save(newUser);
    }

    @Override
    public List<User> searchUserByFirstNameOrLastNameOrEmail(String query) {
        return userRepository.searchUserByFirstNameOrLastNameOrEmail(query);
    }

    @Override
    public User findUserByToken(String token) {
        String email= JwtProvider.getEmailFromToken(token);
        User user=userRepository.findByEmail(email);
        return user;
    }
}
