package com.lukaszbezlada.studentdiary.service;

import com.lukaszbezlada.studentdiary.entity.*;
import com.lukaszbezlada.studentdiary.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {


    private static ClassTypeRepository classTypeRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final TeacherRepository teacherRepository;
    private final StudentRepository studentRepository;
    private static UserRoleRepository roleRepository;

    @Autowired
    public UserService(PasswordEncoder passwordEncoder, TeacherRepository teacherRepository, StudentRepository studentRepository, UserRoleRepository roleRepository, UserRepository userRepository, ClassTypeRepository classTypeRepository) {
        this.passwordEncoder = passwordEncoder;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
        UserService.roleRepository = roleRepository;
        this.userRepository = userRepository;
        UserService.classTypeRepository = classTypeRepository;
    }


    public void addSuitableUserWithEncryptedPassword(UserDTO userDTO) {
        passwordEncrypting(userDTO);
        if (userDTO.getSubject() != null) {
            addTeacher(userDTO);
        } else if (userDTO.getClassType() != null && userDTO.getSubject().equals(SubjectEnum.BRAK)) {
            addStudent(userDTO);
        }
    }

    public void passwordEncrypting(UserDTO userDTO) {
        String passwordHash = passwordEncoder.encode(userDTO.getPassword());
        userDTO.setPassword(passwordHash);
    }

    public void addTeacher(UserDTO userDTO) {
        Teacher teacher = createTeacherFromDTO(userDTO);
        teacherRepository.save(teacher);
    }

    public void addStudent(UserDTO userDTO) {
        SubjectEnum subject = userDTO.getSubject();
        Student student = createStudentFromDTO(userDTO);
        studentRepository.save(student);
    }

//    public void addUser(UserDTO<User> userDTO) {
//        userDTO = new UserDTO<User>(new User());
//        User user = userDTO.getUser();
//        userRepository.save(user);
//    }


    public static Teacher createTeacherFromDTO(UserDTO dto) {
        UserRole teacherRole = roleRepository.findByRole("TEACHER");
        dto.getRoles().add(teacherRole);
        User user = new User(dto.getLogin(), dto.getPassword(), dto.getFirstName(),
                dto.getLastName(), dto.getEmail(), dto.getRoles());
        return new Teacher(null, user, dto.getSubject());
    }

    public static Student createStudentFromDTO(UserDTO dto) {
        UserRole teacherRole = roleRepository.findByRole("STUDENT");
        dto.getRoles().add(teacherRole);
        ClassType classType = classTypeRepository.findByClass(dto.getClassType());
        User user = new User(dto.getLogin(), dto.getPassword(), dto.getFirstName(),
                dto.getLastName(), dto.getEmail(), dto.getRoles());
        return new Student(null, user, classType, null, null);
    }


}
