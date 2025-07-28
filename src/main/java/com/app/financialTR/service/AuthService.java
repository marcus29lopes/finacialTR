package com.app.financialTR.service;

import com.app.financialTR.DTO.UserRegistrationDTO;
import com.app.financialTR.exceptions.InvalidCredentialsException;
import com.app.financialTR.model.Role;
import com.app.financialTR.model.User;
import com.app.financialTR.repository.RoleRepository;
import com.app.financialTR.repository.UserRepository;
import com.app.financialTR.response.UserRegistrationResponse;
import com.app.financialTR.security.UserDetailsImpl;
import com.app.financialTR.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder encoder;


    public String authenticateAndGenerateToken(String email, String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(email, password));

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
            return jwtUtils.generateToken(userDetails.getUsername());

        } catch (BadCredentialsException e) {
            throw new InvalidCredentialsException("Credenciais inválidas");
        }
    }


    public UserRegistrationResponse registerUser(UserRegistrationDTO userRegistrationDTO) {

        Boolean userExists = userRepository.existsByDsEmail(userRegistrationDTO.getDsEmail());

        Role userRole = roleRepository.findByCdRole(1L);

        if (!userExists) {
            String encryptedPassword = encoder.encode(userRegistrationDTO.getDsPassword());

            User newUser = User.builder()
                    .nmUser(userRegistrationDTO.getNmUser())
                    .dsEmail(userRegistrationDTO.getDsEmail())
                    .dsPassword(encryptedPassword)
                    .role(userRole)
                    .build();

            userRepository.save(newUser);

            return UserRegistrationResponse.builder()
                    .dsEmail(newUser.getDsEmail())
                    .nmUser(newUser.getNmUser())
                    .build();
        }

        throw new RuntimeException("User already exists");

    }
}
