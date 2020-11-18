package com.lukaszbezlada.studentdiary.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student extends User implements Serializable {

    @ManyToOne
    @JoinColumn(name = "id_classtype")
    private ClassType studentClass;

    @ManyToOne
    @JoinColumn(name = "id_parent")
    private Parent parent;

    public Student() {
        //for JPA
    }
}
