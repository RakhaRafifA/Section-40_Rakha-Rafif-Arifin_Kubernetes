package com.rakharafifa.miniproject.service;

import java.util.List;

import com.rakharafifa.miniproject.model.entity.User;

public interface UserService {
    List<User> getAllUser();
    User getUserById(Long user_id);
    User createUser(User User);
    void updateUser(Long user_id, User User);
    void deleteUser(Long user_id);
}
