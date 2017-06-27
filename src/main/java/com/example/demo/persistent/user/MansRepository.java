package com.example.demo.persistent.user;

import com.example.demo.domain.user.Man;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author E.Kobets <e.kobets@talantarium.com>
 */
public interface MansRepository extends JpaRepository<Man, Long> {
}
