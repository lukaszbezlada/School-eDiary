package com.lukaszbezlada.studentdiary.service;

import com.lukaszbezlada.studentdiary.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Data
@AllArgsConstructor
public class UserDTO {

    private String login;
    private String password;
    private String password2;
    private String firstName;
    private String lastName;
    private String email;
    private Set<UserRole> roles = new HashSet<>();
    private SubjectEnum subject;
    private Parent parent;
    private List<Grade> grades;
    private String classTypeName;
    private List<Student> childs;

    public UserDTO() {
    }
}
