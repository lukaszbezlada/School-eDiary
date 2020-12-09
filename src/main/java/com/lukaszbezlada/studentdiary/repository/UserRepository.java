package com.lukaszbezlada.studentdiary.repository;

import com.lukaszbezlada.studentdiary.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
}
