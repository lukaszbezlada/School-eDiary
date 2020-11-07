package com.lukaszbezlada.studentdiary.entity;

import lombok.Builder;
import lombok.Data;
import lombok.AllArgsConstructor;

import java.io.Serializable;

@Builder
@Data
@AllArgsConstructor
public class Teacher extends User implements Serializable {

    private SubjectEnum subject;

}
