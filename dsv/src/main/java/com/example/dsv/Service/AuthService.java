package com.example.dsv.Service;

import com.example.dsv.Model.Auth.RegisterUser;
import reactor.core.publisher.Mono;

public interface AuthService {

    Mono<String> registerUser(RegisterUser registerUser);


}
