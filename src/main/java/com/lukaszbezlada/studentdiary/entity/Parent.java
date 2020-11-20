package com.lukaszbezlada.studentdiary.entity;

import lombok.*;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@Entity
@Table(name = "parent")
public class Parent extends User implements Serializable {

    @OneToMany(mappedBy = "parent", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Student> childs;

    public Parent() {
        //for JPA
    }

}
