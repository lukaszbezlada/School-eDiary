package com.lukaszbezlada.studentdiary.repository;

import com.lukaszbezlada.studentdiary.entity.ClassType;
import com.lukaszbezlada.studentdiary.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassTypeRepository extends JpaRepository<UserRole, Long> {
    ClassType findByClass(ClassType classType);
}
