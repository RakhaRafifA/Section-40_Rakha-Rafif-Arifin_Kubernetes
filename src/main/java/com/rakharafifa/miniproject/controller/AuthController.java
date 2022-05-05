package com.rakharafifa.miniproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rakharafifa.miniproject.model.payload.TokenResponse;
import com.rakharafifa.miniproject.model.payload.UsernamePassword;
import com.rakharafifa.miniproject.service.AuthService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/miniproject")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UsernamePassword usernamePassword){
        authService.register(usernamePassword);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> getToken(@RequestBody UsernamePassword usernamePassword){
        TokenResponse token = authService.generateToken(usernamePassword);
        return ResponseEntity.ok(token);
    }

    @GetMapping("/info")
    public ResponseEntity<?> getUsername(){
        UsernamePassword username = new UsernamePassword();
        username.getUsername();
        return ResponseEntity.ok(username);
    }
}
