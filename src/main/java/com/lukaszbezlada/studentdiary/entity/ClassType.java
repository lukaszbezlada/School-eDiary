package com.lukaszbezlada.studentdiary.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@Entity
public class ClassType implements Serializable {

    @Serial
    private static final long serialVersionUID = 6359254733772657789L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "classType", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    private List<Student> studentList;

    public ClassType() {
        //for JPA
    }

}
