package com.lukaszbezlada.studentdiary.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@AllArgsConstructor
@Data
@Entity
@Table(name = "grade")
public class Grade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long value;

    @ManyToOne
    @JoinColumn(name = "id_student")
    private Student student;

    public Grade() {
    }
}
