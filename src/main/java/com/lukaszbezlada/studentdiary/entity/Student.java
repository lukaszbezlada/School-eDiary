package com.lukaszbezlada.studentdiary.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@AllArgsConstructor
@Entity
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private User user;

    @ManyToOne
    @JoinColumn(name = "id_classtype")
    private ClassType classType;

    @ManyToOne
    @JoinColumn(name = "id_parent")
    private Parent parent;

    @OneToMany(mappedBy = "student", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Grade> grades;

    public Student() {
        //for JPA
    }

}
