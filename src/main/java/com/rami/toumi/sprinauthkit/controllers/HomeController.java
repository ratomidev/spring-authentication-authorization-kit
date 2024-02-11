package com.rami.toumi.sprinauthkit.controllers;

import com.rami.toumi.sprinauthkit.entities.User;
import com.rami.toumi.sprinauthkit.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    private final UserService userService;

    @Autowired
    public HomeController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping({"/", "/home"})
    public String HomePage() {
        return "home";
    }
    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody User user){
        userService.addUser(user);
        return ResponseEntity.ok(user);
    }
    @DeleteMapping("/delete/{username}")
    public ResponseEntity<String> deleteUser(@PathVariable String username) {
        userService.deleteUser(username);
        return ResponseEntity.ok("The user is deleted");
    }
    @PostMapping("/info")
    ResponseEntity<String> info() {
        return ResponseEntity.ok("this is a valuable informations");
    }

}
