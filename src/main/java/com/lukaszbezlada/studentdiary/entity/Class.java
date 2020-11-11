package com.lukaszbezlada.studentdiary.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class Class implements Serializable {

    private String name;
    private List<Student> studentList;

    public Class() {
        //for JPA
    }

}
