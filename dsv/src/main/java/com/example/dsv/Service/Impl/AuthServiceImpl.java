package com.example.dsv.Service.Impl;

import com.example.dsv.Model.Auth.RegisterUser;
import com.example.dsv.Model.Auth.User;
import com.example.dsv.Repository.AuthRepository;
import com.example.dsv.Service.AuthService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class AuthServiceImpl implements AuthService {

    private AuthRepository authRepository;

    @Override
    public Mono<String> registerUser(RegisterUser registerUser) {

        return authRepository.findByEmail(registerUser.getEmailId())
                .flatMap(existing ->
                        Mono.<String>error(new RuntimeException("User already exists with the provided email"))
                )
                .switchIfEmpty(authRepository.save(createUser(registerUser))
                        .thenReturn("User created successfully"));
    }

    private User createUser(RegisterUser registerUser) {
        return User.builder()
                .name(registerUser.getName())
                .emailId(registerUser.getEmailId())
                .password(registerUser.getPassword())
                .role("CUSTOMER")
                .build();
    }
}
