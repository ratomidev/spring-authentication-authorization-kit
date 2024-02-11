package com.rami.toumi.sprinauthkit.services;

import com.rami.toumi.sprinauthkit.entities.User;
import com.rami.toumi.sprinauthkit.security.UserDetailsImpl;

import com.rami.toumi.sprinauthkit.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final JdbcUserDetailsManager jdbcUserDetailsManager;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(UserRepository userRepository,
                       JdbcUserDetailsManager jdbcUserDetailsManager, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.jdbcUserDetailsManager =jdbcUserDetailsManager;
        this.passwordEncoder = passwordEncoder;
    }
    public void addUser(User user){
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            jdbcUserDetailsManager.createUser(new UserDetailsImpl(user));
            userRepository.setUserInfoById(
                    user.getEmail(),
                    user.getUsername());
    }

    public void deleteUser(String username) {
        jdbcUserDetailsManager.deleteUser(username);
    }
}
