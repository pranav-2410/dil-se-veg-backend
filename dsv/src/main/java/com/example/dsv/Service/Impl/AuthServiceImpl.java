package com.example.dsv.Service.Impl;

import com.example.dsv.Config.SecurityConfig;
import com.example.dsv.Exceptions.UserAlreadyExists;
import com.example.dsv.Model.Auth.RegisterUser;
import com.example.dsv.Model.Auth.User;
import com.example.dsv.Repository.AuthRepository;
import com.example.dsv.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthRepository authRepository;
    @Autowired
    private SecurityConfig securityConfig;

    @Override
    public Mono<String> registerUser(RegisterUser registerUser) {

        return authRepository.findByEmailId(registerUser.getEmailId())
                .flatMap(existing ->
                        Mono.<String>error(new UserAlreadyExists("User already exists with the provided email"))
                )
                .switchIfEmpty(authRepository.save(createUser(registerUser))
                        .thenReturn("User created successfully"));
    }

    private User createUser(RegisterUser registerUser) {
        return User.builder()
                .name(registerUser.getName())
                .emailId(registerUser.getEmailId())
                .password(passwordEncoder.encode(registerUser.getPassword()))
                .role("CUSTOMER")
                .build();
    }
}
