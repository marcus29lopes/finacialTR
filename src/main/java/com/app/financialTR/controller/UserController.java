package com.app.financialTR.controller;

import com.app.financialTR.DTO.UserRegistrationDTO;
import com.app.financialTR.response.JwtResponse;
import com.app.financialTR.response.UserRegistrationResponse;
import com.app.financialTR.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/FTR")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value = "/register")
    public ResponseEntity<UserRegistrationResponse> registerUser(@RequestBody UserRegistrationDTO user) {
        return new ResponseEntity<>(userService.registerUser(user), HttpStatus.CREATED);
    }
}
