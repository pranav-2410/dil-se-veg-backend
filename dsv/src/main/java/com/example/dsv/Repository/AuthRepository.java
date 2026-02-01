package com.example.dsv.Repository;

import com.example.dsv.Model.Auth.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface AuthRepository extends ReactiveCrudRepository<User, Long> {

    Mono<User> findByEmailId(String emailId);
}
