package com.lukaszbezlada.studentdiary.entity;


import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private SubjectEnum subject;

    public Subject() {
        //for JPA
    }

}

