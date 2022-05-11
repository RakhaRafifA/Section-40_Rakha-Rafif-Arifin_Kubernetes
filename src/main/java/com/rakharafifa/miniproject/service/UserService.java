package com.rakharafifa.miniproject.service;

import java.util.List;

import com.rakharafifa.miniproject.model.dto.UserDto;
import com.rakharafifa.miniproject.model.entity.User;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    List<User> getAllUser();
    List<UserDto> getAllUserDto();
    User getUserById(Long user_id);
    void createUserDto(UserDto userDtos);
    void updateUser(Long user_id, User User);
    void deleteUser(Long user_id);
}
