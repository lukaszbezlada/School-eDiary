package com.lukaszbezlada.studentdiary.repository;

import com.lukaszbezlada.studentdiary.entity.ClassType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Transactional
@Repository
public interface ClassTypeRepository extends JpaRepository<ClassType, Long> {
    Optional<ClassType> findByName(String name);
}
