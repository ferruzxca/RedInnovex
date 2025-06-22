package com.innovexmedia.controller;

import com.innovexmedia.model.User;
import com.innovexmedia.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestParam String username,
                                         @RequestParam String email,
                                         @RequestParam String password) {
        return ResponseEntity.ok(authService.register(username, email, password));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestParam String username,
                                        @RequestParam String password) {
        return ResponseEntity.ok(authService.login(username, password));
    }
}
