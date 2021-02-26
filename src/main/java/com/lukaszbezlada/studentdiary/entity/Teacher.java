package com.lukaszbezlada.studentdiary.entity;

import com.lukaszbezlada.studentdiary.repository.UserRoleRepository;
import com.lukaszbezlada.studentdiary.service.UserDTO;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id) && Objects.equals(user, teacher.user) && subject == teacher.subject;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, subject);
    }
}
