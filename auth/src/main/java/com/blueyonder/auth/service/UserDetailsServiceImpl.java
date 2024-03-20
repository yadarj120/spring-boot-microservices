package com.blueyonder.auth.service;

import com.blueyonder.auth.model.User;
import com.blueyonder.auth.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> userOptional = Optional.ofNullable(repository.findByEmail(email));

        User user;
        if (userOptional.isPresent()) {
            user = userOptional.get();
            return org.springframework.security.core.userdetails.User.builder()
                    .username(user.getEmail())
                    .password(user.getPassword())
                    .roles(user.getIsAdmin() ? "ADMIN" : "USER")
                    .build();
        } else {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
    }
}