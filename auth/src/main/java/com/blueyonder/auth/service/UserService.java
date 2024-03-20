package com.blueyonder.auth.service;

import com.blueyonder.auth.controller.dto.SignupRequest;
import com.blueyonder.auth.exception.DuplicateException;
import com.blueyonder.auth.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.blueyonder.auth.model.User;

import java.util.Optional;

@Service
@Transactional
public class UserService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void signup(SignupRequest request) {
        String email = request.getEmail();
        Optional<User> existingUser = Optional.ofNullable(repository.findByEmail(email));
        if (existingUser.isPresent()) {
            throw new DuplicateException(String.format("User with the email address '%s' already exists.", email));
        }

        String hashedPassword = passwordEncoder.encode(request.getPassword());
        User user = new User(request.getName(), email, hashedPassword, false);
        repository.save(user);
    }

}
