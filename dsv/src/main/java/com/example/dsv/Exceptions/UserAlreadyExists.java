package com.example.dsv.Exceptions;

public class UserAlreadyExists extends RuntimeException{

    public UserAlreadyExists(String message){
        super(message);
    }
}
