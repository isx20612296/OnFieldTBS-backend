package org.proyectofinal.OnFieldTBS.controllers;

import org.proyectofinal.OnFieldTBS.services.UserService;
import org.proyectofinal.OnFieldTBS.utils.ListResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.proyectofinal.OnFieldTBS.utils.ListResult.list;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService services;

    public UserController(UserService services) {
        this.services = services;
    }

    @GetMapping
    public ResponseEntity<ListResult> getAllUser() {
        return ResponseEntity.ok().body(list(services.getAllUsers()));
    }

    // Login
    @GetMapping("/login")
    public ResponseEntity<?> login() {
        return ResponseEntity.ok().build();
    }
}
