package com.rami.toumi.sprinauthkit.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class UserManagementConfig {
    @Bean
    public JdbcUserDetailsManager userDetailsService(DataSource dataSource) {
        JdbcUserDetailsManager jdbc = new JdbcUserDetailsManager(dataSource);

       return jdbc ;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
