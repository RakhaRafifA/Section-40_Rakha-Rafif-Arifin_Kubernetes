package com.rakharafifa.miniproject.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.rakharafifa.miniproject.model.entity.UserEntity;
import com.rakharafifa.miniproject.repository.UserRepository;
import com.rakharafifa.miniproject.service.implementation.UserServiceImpl;

import org.jeasy.random.EasyRandom;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
    private final EasyRandom EASY_RANDOM = new EasyRandom();

    @InjectMocks
    private UserServiceImpl service;

    @Mock
    private UserRepository repository;
    
    @Test
    void findAllUser(){
        List<UserEntity> users = EASY_RANDOM.objects(UserEntity.class, 2)
        .collect(Collectors.toList());

        when(repository.findAll()).thenReturn(users);
        service.getAllUser();
        verify(repository, times(1)).findAll();
    }

    @Test
    void findUserById(){
        UserEntity user = new UserEntity();
        user.setUser_id(1L);
        user.setName("Rakha");
        user.setUsername("rakha");
        user.setPassword("password");
        System.out.println(user);

        when(repository.findById(user.getUser_id())).thenReturn(Optional.of(user));
        service.getUserById(user.getUser_id());
        verify(repository, times(1)).findById(user.getUser_id());
    }

    // @Test
    // void createNewUser(){
    //     User user = new User();
    //     user.setUser_id(1L);
    //     user.setName("Rakha");
    //     user.setUsername("rakha");
    //     user.setPassword("password");
    //     System.out.println(user);

    //     when(repository.save(user)).thenReturn(user);
    //     service.createUser(user);
    //     verify(repository, times(1)).save(user);
    // }

    @Test
    public void deleteUserById(){
        UserEntity user = EASY_RANDOM.nextObject(UserEntity.class);

        service.deleteUser(user.getUser_id());
        verify(repository).deleteById(user.getUser_id());
    }

    @Test
    public void whenGivenId_shouldUpdateUser_ifFound() {
        UserEntity user = new UserEntity();
        user.setUser_id(1L);
        user.setName("Rakha");
        user.setUsername("rakha");
        user.setPassword("password");
        
        UserEntity newUser = new UserEntity();
        newUser.setName("Baru");

        when(repository.findById(user.getUser_id())).thenReturn(Optional.of(user));
        service.updateUser(user.getUser_id(), newUser);
        verify(repository).save(user);
        verify(repository).findById(user.getUser_id());
    }
}
