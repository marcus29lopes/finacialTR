package com.app.financialTR.service;

import com.app.financialTR.model.User;
import com.app.financialTR.repository.UserRepository;
import com.app.financialTR.security.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userEmail) throws UsernameNotFoundException {
        User user = userRepository.findByDsEmail(userEmail)
                .orElseThrow(() -> new UsernameNotFoundException("User " + userEmail + " not found"));

        return new UserDetailsImpl(user);
    }
}
