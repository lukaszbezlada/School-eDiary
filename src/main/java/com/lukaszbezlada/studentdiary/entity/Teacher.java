package com.lukaszbezlada.studentdiary.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@SuperBuilder
@EqualsAndHashCode (callSuper = true)
@Data
@AllArgsConstructor
@Entity
@Table(name = "teacher")
public class Teacher extends User implements Serializable {

    @Column
    private SubjectEnum subject;

    public Teacher() {
        //for Spring Data JPA
    }
}
