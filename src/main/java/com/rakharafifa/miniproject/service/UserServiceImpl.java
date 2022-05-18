package com.rakharafifa.miniproject.service;

import java.util.ArrayList;
import java.util.List;

import com.rakharafifa.miniproject.model.dto.UserDto;
import com.rakharafifa.miniproject.model.entity.User;
import com.rakharafifa.miniproject.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.getDistinctTopByUsername(username);
        if (user == null)
        throw new UsernameNotFoundException("Username not Found");
        return user;
    }

    @Override
    public List<User> getAllUser() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public List<UserDto> getAllUserDto() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtos = new ArrayList<>();
        
        users.forEach(isi ->{
            UserDto dto = new UserDto();
            dto.setUser_id(isi.getUser_id());
            dto.setName(isi.getName());
            dto.setUsername(isi.getUsername());

            userDtos.add(dto);
        });
        return userDtos;
    }

    @Override
    public User getUserById(Long user_id) {
        return userRepository.findById(user_id).get();
    }

    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(Long user_id, User user) {
        User user2 = userRepository.findById(user_id).get();
        System.out.println(user2.toString());
        user2.setName(user.getName());
        user2.setUsername(user.getUsername());
        user2.setPassword(user.getPassword());
        userRepository.save(user2);
    }

    @Override
    public void deleteUser(Long user_id) {
        userRepository.deleteById(user_id);
    }
}
