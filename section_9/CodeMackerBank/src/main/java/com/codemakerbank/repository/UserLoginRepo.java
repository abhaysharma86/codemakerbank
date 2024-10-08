package com.codemakerbank.repository;

import com.codemakerbank.models.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserLoginRepo extends JpaRepository<UserLogin,Long> {
    Optional<UserLogin> findByEmail(String email);

}
