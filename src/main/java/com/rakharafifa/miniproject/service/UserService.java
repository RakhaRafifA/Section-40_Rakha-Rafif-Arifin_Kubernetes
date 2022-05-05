package com.rakharafifa.miniproject.service;

import java.util.List;

import com.rakharafifa.miniproject.model.entity.User;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    List<User> getAllUser();
    User getUserById(Long user_id);
    User createUser(User user);
    void updateUser(Long user_id, User User);
    void deleteUser(Long user_id);
}
