package com.lukaszbezlada.studentdiary.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;


public class User implements Serializable {

    private Long id;
    private String login;
    private String password;
    private String password2;
    private String firstName;
    private String lastName;
    private String email;
    private Set<UserRole> roles = new HashSet<>();


}