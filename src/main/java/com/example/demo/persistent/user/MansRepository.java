package com.example.demo.persistent.user;

import com.example.demo.domain.Man;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MansRepository extends JpaRepository<Man, Long> {
}
