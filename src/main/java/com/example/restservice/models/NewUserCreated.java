package com.example.restservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewUserCreated {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String direction;
}
