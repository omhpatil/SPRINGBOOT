package com.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
                        .requestMatchers("/public").permitAll() // anyone
                        .requestMatchers("/admin").hasRole("ADMIN") // only admin
                        .anyRequest().authenticated() // everything else -> login
                )
                .formLogin(Customizer.withDefaults()) // enable login form
                .logout(Customizer.withDefaults());    // logout functionality
        return http.build();
    }

}
