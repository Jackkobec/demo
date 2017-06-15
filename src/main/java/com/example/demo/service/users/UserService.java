package com.example.demo.service.users;

import com.example.demo.domain.user.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUserById(Long id);
}
