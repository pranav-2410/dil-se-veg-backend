package com.example.dsv.Model.Auth;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table(name = "users")
@Data
@Builder
public class User {

    @Id
    private long id;

    private String name;
    private String password;
    private String emailId;
    private String role;
}
