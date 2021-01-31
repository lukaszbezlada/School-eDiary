package com.lukaszbezlada.studentdiary.service;

import com.lukaszbezlada.studentdiary.entity.*;
import com.lukaszbezlada.studentdiary.repository.StudentRepository;
import com.lukaszbezlada.studentdiary.repository.TeacherRepository;
import com.lukaszbezlada.studentdiary.repository.UserRepository;
import com.lukaszbezlada.studentdiary.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserDTOService {

    private final PasswordEncoder passwordEncoder;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final UserRoleRepository roleRepository;

    @Autowired
    public UserDTOService(PasswordEncoder passwordEncoder, TeacherRepository teacherRepository, StudentRepository studentRepository, UserRoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.roleRepository = roleRepository;
    }


    public void addSuitableUserWithEncryptedPassword(UserDTO userDTO) {
        if (userDTO.getSubject() != null) {
            UserRole defaultRole = roleRepository.findByRole(2);
            userDTO.getRoles().add(defaultRole);
            passwordEncrypting(userDTO);
            addTeacher(userDTO);
        }
        if (userDTO.getClassType() != null) {
            addStudent(userDTO);
        }
    }

    public void passwordEncrypting(UserDTO userDTO) {
        String passwordHash = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(passwordHash);
    }

    public void addTeacher(UserDTO<Teacher> userDTO) {
        // userDTO = new UserDTO<Teacher>(new Teacher());
        Teacher teacher = userDTO.getUser();
        teacherRepository.save(teacher);
    }

    public void addStudent(UserDTO<Student> userDTO) {
        Student student = userDTO.getUser();
        studentRepository.save(student);
    }


}
