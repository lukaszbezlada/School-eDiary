package com.lukaszbezlada.studentdiary.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
public class Student extends User implements Serializable {

    private Class studentClass;
    private Parent parent;

    public Student() {
        //for JPA
    }
}
