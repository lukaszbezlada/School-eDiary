package com.lukaszbezlada.studentdiary.repository;

import com.lukaszbezlada.studentdiary.entity.Student;
import com.lukaszbezlada.studentdiary.entity.SubjectEnum;
import com.lukaszbezlada.studentdiary.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@RepositoryRestResource(path = "teacher")
public interface TeacherRepository extends JpaRepository<Teacher, Long> {

    Optional<Student> findBySubject(SubjectEnum subject);
}