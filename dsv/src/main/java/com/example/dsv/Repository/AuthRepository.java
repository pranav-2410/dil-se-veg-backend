package com.example.dsv.Repository;

import com.example.dsv.Model.Auth.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface AuthRepository extends ReactiveCrudRepository<User, String> {

    Mono<User> findByEmail(String emailId);
}
