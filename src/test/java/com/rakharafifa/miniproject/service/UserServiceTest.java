package com.rakharafifa.miniproject.service;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.rakharafifa.miniproject.model.entity.User;
import com.rakharafifa.miniproject.repository.UserRepository;

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
        List<User> users = EASY_RANDOM.objects(User.class, 2)
        .collect(Collectors.toList());

        when(repository.findAll()).thenReturn(users);
        service.getAllUser();
        verify(repository, times(1)).findAll();
    }

    @Test
    void findUserById(){
        User user = EASY_RANDOM.nextObject(User.class);
        System.out.println(user);

        when(repository.findById(user.getUser_id())).thenReturn(Optional.of(user));
        service.getUserById(user.getUser_id());
        verify(repository, times(1)).findById(user.getUser_id());
    }

    @Test
    void createNewUser(){
        User user = EASY_RANDOM.nextObject(User.class);
        System.out.println(user);

        when(repository.save(user)).thenReturn(user);
        service.createUser(user);
        verify(repository, times(1)).save(user);
    }

    @Test
    public void deleteUserById(){
        User user = EASY_RANDOM.nextObject(User.class);

        service.deleteUser(user.getUser_id());
        verify(repository).deleteById(user.getUser_id());
    }

    @Test
    public void whenGivenId_shouldUpdateUser_ifFound() {
        User user = EASY_RANDOM.nextObject(User.class);
        User newUser = new User();
        newUser.setName("Baru");

        when(repository.findById(user.getUser_id())).thenReturn(Optional.of(user));
        service.updateUser(user.getUser_id(), newUser);
        verify(repository).save(user);
        verify(repository).findById(user.getUser_id());
    }
}
