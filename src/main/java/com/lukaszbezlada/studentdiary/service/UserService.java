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
public class UserService {

    @Autowired
    UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private final UserRoleRepository roleRepository;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder, TeacherRepository teacherRepository, StudentRepository studentRepository, UserRoleRepository roleRepository) {
        this.passwordEncoder = passwordEncoder;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        this.roleRepository = roleRepository;
    }


    public void addSuitableUserWithEncryptedPassword(UserDTO userDTO) {
        if (userDTO.getSubject() != null) {
            passwordEncrypting(userDTO);
            addTeacher(userDTO);
        }
    }


    public void passwordEncrypting(UserDTO userDTO) {
        String passwordHash = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(passwordHash);
    }

    public void addTeacher(UserDTO userDTO) {
        Teacher teacher = Teacher.fromDTO(userDTO);
        teacherRepository.save(teacher);
    }

//    public void addStudent(UserDTO<Student> userDTO) {
//        userDTO = new UserDTO<Student>(new Student());
//        Student student = userDTO.getUser();
//        studentRepository.save(student);
//    }
//
//    public void addUser(UserDTO<User> userDTO) {
//        userDTO = new UserDTO<User>(new User());
//        User user = userDTO.getUser();
//        userRepository.save(user);
//    }


}
