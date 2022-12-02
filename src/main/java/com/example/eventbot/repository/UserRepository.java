package com.example.eventbot.repository;

import com.example.eventbot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Alexander Iablonski
 */

public interface UserRepository extends JpaRepository<User, Long> {
    User findById(long id);
}
