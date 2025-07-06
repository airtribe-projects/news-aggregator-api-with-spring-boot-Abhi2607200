package com.airtribe.aggregatorApi.Service;

import com.airtribe.aggregatorApi.DTO.AuthResponse;
import com.airtribe.aggregatorApi.DTO.LoginRequest;
import com.airtribe.aggregatorApi.DTO.Loginrequest;
import com.airtribe.aggregatorApi.DTO.RegisterRequest;

import com.airtribe.aggregatorApi.DTO.RegistrationRequest;
import com.airtribe.aggregatorApi.Entity.User;
import com.airtribe.aggregatorApi.repository.UserRepository;
import com.airtribe.aggregatorApi.Security.JwtUtil;
import lombok.RequiredArgsConstructor;

import org.springframework.aot.hint.annotation.RegisterReflection;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements Authservice {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse register(RegisterReflection request) {
        user user = user.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .roles(Collections.singleton("USER"))
                .build();

        userRepository.save(user);

        String token = jwtUtil.generateToken(user.getUsername());
        return new AuthResponse(token, user.getUsername());
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        String token = jwtUtil.generateToken(request.getUsername());
        return new AuthResponse(token, request.getUsername());
    }

    @Override
    public AuthResponse register(RegistrationRequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'register'");
    }

    @Override
    public AuthResponse login(Loginrequest request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }
}
