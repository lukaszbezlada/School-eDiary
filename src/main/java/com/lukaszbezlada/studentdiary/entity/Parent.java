package com.lukaszbezlada.studentdiary.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class Parent extends User implements Serializable {

    private List<Student> childs;

    public Parent() {
        //for JPA
    }
}
