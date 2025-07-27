package com.app.financialTR.controller;

import com.app.financialTR.DTO.UserRegistrationDTO;
import com.app.financialTR.response.LoginRequest;
import com.app.financialTR.response.JwtResponse;
import com.app.financialTR.response.UserRegistrationResponse;
import com.app.financialTR.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/FTR/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody LoginRequest loginRequest) {

        try {
            String token = authService.authenticateAndGenerateToken(loginRequest.getEmail(), loginRequest.getPassword());
            return ResponseEntity.ok(new JwtResponse(token));

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new JwtResponse("Invalid credentials"));
        }


    }

    @PostMapping(value = "/register")
    public ResponseEntity<UserRegistrationResponse> registerUser(@RequestBody UserRegistrationDTO user) {
        return new ResponseEntity<>(authService.registerUser(user), HttpStatus.CREATED);
    }
}
