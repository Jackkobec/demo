package com.example.demo.persistent.user;

import com.example.demo.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<User, Long> {
}
