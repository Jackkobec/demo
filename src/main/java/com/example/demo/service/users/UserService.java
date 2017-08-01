package com.example.demo.service.users;

import com.example.demo.domain.Girl;
import com.example.demo.domain.Man;
import com.example.demo.domain.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUserById(Long id);

    List<Man> getMans();

    List<Girl> getGirls();
}
