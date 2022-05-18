package com.rakharafifa.miniproject.service.auth;

import com.rakharafifa.miniproject.model.entity.UserEntity;
import com.rakharafifa.miniproject.model.payload.TokenResponse;
import com.rakharafifa.miniproject.model.payload.UsernamePassword;

public interface AuthService {
    UserEntity register(UsernamePassword req);
    TokenResponse generateToken(UsernamePassword req);
}
