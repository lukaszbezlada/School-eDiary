package com.lukaszbezlada.studentdiary.entity;

import com.lukaszbezlada.studentdiary.repository.UserRoleRepository;
import com.lukaszbezlada.studentdiary.service.UserDTO;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher implements Serializable {

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
