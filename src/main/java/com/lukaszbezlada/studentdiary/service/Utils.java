package com.lukaszbezlada.studentdiary.service;

import com.lukaszbezlada.studentdiary.entity.Teacher;
import com.lukaszbezlada.studentdiary.entity.User;
import com.lukaszbezlada.studentdiary.entity.UserRole;
import com.lukaszbezlada.studentdiary.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class Utils {

    @Autowired
    private static UserRoleRepository roleRepository;

    public static Teacher fromDTO(UserDTO dto) {
        UserRole teacherRole = roleRepository.findByRole("TEACHER");
        dto.getRoles().add(teacherRole);
        User user = new User(dto.getLogin(), dto.getPassword(), dto.getFirstName(),
                dto.getLastName(), dto.getEmail(), dto.getRoles());
        return new Teacher(null, user, dto.getSubject());
    }
}
