package com.example.demo.persistent.user;

import com.example.demo.domain.user.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author E.Kobets <e.kobets@talantarium.com>
 * 6/26/17
 */
public interface GirlsRepository extends JpaRepository<Girl, Long> {
}
