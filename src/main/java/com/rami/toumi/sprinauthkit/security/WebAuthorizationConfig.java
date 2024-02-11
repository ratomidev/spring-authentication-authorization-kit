package com.rami.toumi.sprinauthkit.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class WebAuthorizationConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.authorizeRequests(requests -> requests
                        .requestMatchers("/register").permitAll()
                        .requestMatchers("/delete/**").hasAuthority("DELETE")
                        .anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults()) .csrf((csrf)->csrf.disable());

        return http.build();
    }
}