package com.example.demo.service.users;

import com.example.demo.domain.user.Girl;
import com.example.demo.domain.user.Man;
import com.example.demo.domain.user.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getUserById(Long id);

    List<Man> getMans();

    List<Girl> getGirls();
}
