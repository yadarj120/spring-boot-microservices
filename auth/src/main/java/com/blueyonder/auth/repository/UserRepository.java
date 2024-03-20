package com.blueyonder.auth.repository;

import com.blueyonder.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail(String email);
}
