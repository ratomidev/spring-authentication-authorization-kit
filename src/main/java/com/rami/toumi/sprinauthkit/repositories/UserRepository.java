package com.rami.toumi.sprinauthkit.repositories;

import com.rami.toumi.sprinauthkit.entities.User;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.SQLIntegrityConstraintViolationException;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query("update User u set u.email = ?1 where u.username = ?2")
    void setUserInfoById(String email, String username);

    }
