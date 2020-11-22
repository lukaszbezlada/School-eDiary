package com.lukaszbezlada.studentdiary.repository;

import com.lukaszbezlada.studentdiary.entity.Student;
import com.lukaszbezlada.studentdiary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@RepositoryRestResource(path = "user")
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<Student> findByFirstName(String name);
}
