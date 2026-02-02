package com.example.dsv.Model.Auth;

public record LoginResponse(String token,
                            String role,
                            String userId,
                            String name) {
}
