package com.app.financialTR.controller;

import com.app.financialTR.DTO.LoginRequestDTO;
import com.app.financialTR.DTO.UserRegistrationDTO;
import com.app.financialTR.response.JwtResponse;
import com.app.financialTR.response.UserRegistrationResponse;
import com.app.financialTR.service.AuthService;
import com.app.financialTR.service.EmailService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/FTR/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @Autowired
    private EmailService emailService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
        String token = authService.authenticateAndGenerateToken(loginRequestDTO.getDsEmail(), loginRequestDTO.getDsPassword());
        return ResponseEntity.ok(new JwtResponse(token));
    }

    @PostMapping(value = "/register")
    public ResponseEntity<UserRegistrationResponse> registerUser(@RequestBody UserRegistrationDTO user) {
        UserRegistrationResponse registered = authService.registerUser(user);
        emailService.sendWelcomeEmail(user.getDsEmail(), user.getNmUser());
        return new ResponseEntity<>(registered, HttpStatus.CREATED);
    }
}
