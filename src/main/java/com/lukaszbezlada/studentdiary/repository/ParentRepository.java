package com.lukaszbezlada.studentdiary.repository;

import com.lukaszbezlada.studentdiary.entity.Parent;
import com.lukaszbezlada.studentdiary.entity.Student;
import com.lukaszbezlada.studentdiary.entity.SubjectEnum;
import com.lukaszbezlada.studentdiary.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@RepositoryRestResource(path = "teacher")
public interface ParentRepository extends JpaRepository<Parent, Long> {

    Optional<Student> findByChilds(Student student);
}