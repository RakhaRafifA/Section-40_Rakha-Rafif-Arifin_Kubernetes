package com.rakharafifa.miniproject.service;

import com.rakharafifa.miniproject.model.entity.User;
import com.rakharafifa.miniproject.model.payload.TokenResponse;
import com.rakharafifa.miniproject.model.payload.UsernamePassword;

public interface AuthService {
    User register(UsernamePassword req);
    TokenResponse generateToken(UsernamePassword req);
}
