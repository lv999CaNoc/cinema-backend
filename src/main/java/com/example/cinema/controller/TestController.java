package com.example.cinema.controller;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
@AllArgsConstructor
public class TestController {
    @GetMapping ("/user")
    @PreAuthorize("hasRole('ROLE_USER')")
    public String test(){
        return "Hello User";
    }
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public String test1(){
        return "Hello Admin";
    }
}
