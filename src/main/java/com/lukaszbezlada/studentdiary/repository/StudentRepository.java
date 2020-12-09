package com.lukaszbezlada.studentdiary.repository;

import com.lukaszbezlada.studentdiary.entity.Parent;
import com.lukaszbezlada.studentdiary.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Optional<Student> findByParent(Parent parent);
}
