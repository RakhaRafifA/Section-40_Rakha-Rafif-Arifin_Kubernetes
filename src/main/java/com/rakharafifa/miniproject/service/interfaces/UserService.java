package com.rakharafifa.miniproject.service.interfaces;

import java.util.List;

import com.rakharafifa.miniproject.model.dto.UserDto;
import com.rakharafifa.miniproject.model.entity.UserEntity;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
    List<UserEntity> getAllUser();
    List<UserDto> getAllUserDto();
    UserEntity getUserById(Long user_id);
    void createUser(UserEntity user);
    void updateUser(Long user_id, UserEntity User);
    void deleteUser(Long user_id);
}
