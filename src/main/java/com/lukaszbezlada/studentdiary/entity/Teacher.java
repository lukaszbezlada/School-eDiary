package com.lukaszbezlada.studentdiary.entity;

import com.lukaszbezlada.studentdiary.repository.UserRoleRepository;
import com.lukaszbezlada.studentdiary.service.UserDTO;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {


    @Autowired
    private static UserRoleRepository roleRepository;

    public static Teacher fromDTO(UserDTO dto) {
        UserRole teacherRole = roleRepository.findByRole("TEACHER");
        dto.getRoles().add(teacherRole);
        User user = new User(dto.getLogin(), dto.getPassword(), dto.getFirstName(),
                dto.getLastName(), dto.getEmail(), dto.getRoles());
        return new Teacher(null, user, dto.getSubject());
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    private User user;

    @Column
    private SubjectEnum subject;

    public Teacher() {
        //for Spring Data JPA
    }
}
