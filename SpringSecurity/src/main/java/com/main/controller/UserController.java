package com.main.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Here in this project i have hardcoded users details in the application.properties
// They are not getting fetched from database because of hardcoded also called as inMemoryUserDetailsManager.

@RestController
public class UserController {

    // public endpoint - no login required
    @GetMapping("/public")
    public String publicPage() {
        return "Hey Buddy";
    }

    // private endpoint - login required
    @GetMapping("/private")
    public String privatePage() {
        // get currently logged in user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        String username = auth.getName();
        String roles = auth.getAuthorities().toString();

        return "Welcome " + username + "! You roles: " + roles;

    }

    @GetMapping("/normaluser")
    public String normalUserPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return "Hey " + auth.getName();
    }

    // showing security context information - who i am!
    @GetMapping("/whoiam")
    public String whoIamPage() {
        // get currently logged in user
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

        return "Principal: " + auth.getPrincipal() + "\n" +
                "Authentication: " + auth.isAuthenticated() + "\n" +
                "Authorities: " + auth.getAuthorities();
    }

    // practice
    @GetMapping("/admin")
    public String adminPage() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();

//        return "Hello Admin, user = " + auth.getName();
        return auth.toString();
    }

}
