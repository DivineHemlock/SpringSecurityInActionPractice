package com.example.springsecurityinaction.security;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class DummyUser{
    @Id
    private String id;
    private String username;
    private String password;
    private String authority;
}
