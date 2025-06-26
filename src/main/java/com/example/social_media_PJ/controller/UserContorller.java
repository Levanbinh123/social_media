package com.example.social_media_PJ.controller;

import com.example.social_media_PJ.model.User;
import com.example.social_media_PJ.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserContorller {
    @Autowired

    UserService userService;
    @PostMapping
    public ResponseEntity<?> addUser(@RequestBody User user) throws Exception{
        User registedUser=userService.addUser(user);
        return ResponseEntity.ok(registedUser);
    }
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) throws Exception{
        User user = userService.findUserById(id);
        return ResponseEntity.ok().body(user);
    }
    @PutMapping()
    public ResponseEntity<User> updateUser( @RequestHeader("Authorization") String token,@RequestBody User user) throws Exception{
       User requestUser=userService.findUserByToken(token);
        User u = userService.updateUser(user,requestUser.getId());
        return ResponseEntity.ok().body(u);
    }
    @PutMapping("/follow/{userId2}")
    public ResponseEntity<User> flollowUserHandler( @RequestHeader("Authorization") String token,@PathVariable Integer userId) throws Exception{
        User requestUser=userService.findUserByToken(token);
        User user=userService.followUser( requestUser.getId(),userId);
        return ResponseEntity.ok().body(user);


    }
    @GetMapping("/search")
    public ResponseEntity<List<User>> searchUser (@Param("query") String query){
        List<User> users=userService.searchUserByFirstNameOrLastNameOrEmail(query);
        return ResponseEntity.ok().body(users);
    }
    @GetMapping("/profile")
    public User getUserserByToken(@RequestHeader("Authorization") String token) throws Exception{
        User user=userService.findUserByToken(token);
        user.setPassword(null);
        return user;
    }

}
