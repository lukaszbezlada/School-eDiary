package com.lukaszbezlada.studentdiary.entity;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Builder
@Data
@AllArgsConstructor
public class User implements Serializable {

    private Long id;
    private String login;
    private String password;
    private String password2;
    private String firstName;
    private String lastName;
    private String email;
    private Set<UserRole> roles = new HashSet<>();

    public User() {
        //for Spring Data JPA
    }
}