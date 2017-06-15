package com.example.demo.representation;

import com.example.demo.domain.user.User;
import com.example.demo.service.users.UserServiceImpl;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class MainResource {

    @Inject
    public UserServiceImpl userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public User getUserDetails(@PathVariable Long id) {

        return userService.getUserById(id);
    }
}
