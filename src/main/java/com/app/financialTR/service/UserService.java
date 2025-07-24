package com.app.financialTR.service;

import com.app.financialTR.DTO.UserRegistrationDTO;
import com.app.financialTR.model.Role;
import com.app.financialTR.model.User;
import com.app.financialTR.repository.RoleRepository;
import com.app.financialTR.repository.UserRepository;
import com.app.financialTR.response.UserRegistrationResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    PasswordEncoder encoder;
    @Autowired
    RoleRepository roleRepository;

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
