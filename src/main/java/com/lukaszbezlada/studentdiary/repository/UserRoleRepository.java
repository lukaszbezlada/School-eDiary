package com.lukaszbezlada.studentdiary.repository;

import com.lukaszbezlada.studentdiary.entity.UserRole;
import com.lukaszbezlada.studentdiary.entity.UserRoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    UserRole findByRole(int role);
}
