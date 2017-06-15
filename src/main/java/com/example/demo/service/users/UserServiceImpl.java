package com.example.demo.service.users;

import com.example.demo.domain.user.User;
import com.example.demo.persistent.user.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Inject
    public UsersRepository usersRepository;

    @Override
    public List<User> getUsers() {
        return usersRepository.findAll();
    }

    @Override
    public User getUserById(final Long id) {

        return usersRepository.findOne(id);
    }
}
