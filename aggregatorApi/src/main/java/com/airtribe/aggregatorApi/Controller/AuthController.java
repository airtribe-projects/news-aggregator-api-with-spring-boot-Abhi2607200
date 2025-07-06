package com.airtribe.aggregatorApi.Controller;

import com.airtribe.aggregatorApi.DTO.AuthResponse;
import com.airtribe.aggregatorApi.DTO.Loginrequest;
import com.airtribe.aggregatorApi.DTO.RegistrationRequest;
import com.airtribe.aggregatorApi.Security.*;
import com.airtribe.aggregatorApi.Service.Authservice;
import com.airtribe.aggregatorApi.DTO.RegisterRequest;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class AuthController {

    private final Authservice authService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@Valid @RequestBody RegistrationRequest request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@Valid @RequestBody Loginrequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}
