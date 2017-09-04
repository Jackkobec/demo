package com.example.demo.persistent.user;

import com.example.demo.domain.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GirlsRepository extends JpaRepository<Girl, Long> {
}
