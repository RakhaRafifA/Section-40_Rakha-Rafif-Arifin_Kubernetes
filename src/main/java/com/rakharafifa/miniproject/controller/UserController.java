package com.rakharafifa.miniproject.controller;

import java.util.List;

import com.rakharafifa.miniproject.model.dto.UserDto;
import com.rakharafifa.miniproject.model.entity.User;
import com.rakharafifa.miniproject.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/miniproject/user")
public class UserController {
    UserService userService;

    @Autowired
    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser(){
        List<User> users = userService.getAllUser();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/dto")
    public ResponseEntity<List<UserDto>> getAllUserDto(){
        List<UserDto> userDtos = userService.getAllUserDto();
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @GetMapping("/{user_id}")
    public ResponseEntity<User> getUserById(@PathVariable("user_id") Long user_id){
        return new ResponseEntity<>(userService.getUserById(user_id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UserDto> createUserDto(@RequestBody UserDto userDtos){
        userService.createUserDto(userDtos);
        return new ResponseEntity<>(userDtos, HttpStatus.OK);
    }

    @PutMapping("/{user_id}")
    public ResponseEntity<User> updateUser(@PathVariable("user_id") Long user_id, @RequestBody User user){
        userService.updateUser(user_id, user);
        return new ResponseEntity<>(userService.getUserById(user_id), HttpStatus.OK);
    }

    @DeleteMapping("/{user_id}")
    public ResponseEntity<User> deleteUser(@PathVariable("user_id") Long user_id){
        userService.deleteUser(user_id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
