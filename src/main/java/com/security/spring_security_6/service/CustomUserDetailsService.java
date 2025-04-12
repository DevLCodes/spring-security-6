package com.security.spring_security_6.service;

import com.security.spring_security_6.entity.CustomUserDetails;
import com.security.spring_security_6.entity.User;
import com.security.spring_security_6.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(username);
        if (Objects.isNull(user)) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return new CustomUserDetails(user);
    }
}
