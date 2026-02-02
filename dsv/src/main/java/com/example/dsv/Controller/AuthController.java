package com.example.dsv.Controller;

import com.example.dsv.Model.Auth.LoginResponse;
import com.example.dsv.Model.Auth.LoginUser;
import com.example.dsv.Model.Auth.RegisterUser;
import com.example.dsv.Service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/register")
    public Mono<ResponseEntity<String>> registerUser (@RequestBody RegisterUser user) {


        return authService.registerUser(user)
                .map(response ->
                        ResponseEntity.status(HttpStatus.CREATED)
                        .body(response)
                );
    }

    @PostMapping("/login")
    public Mono<LoginResponse> loginUser (@RequestBody LoginUser user) {
        return authService.loginUser(user);
    }
}
