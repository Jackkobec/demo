package com.example.demo.representation;

import com.example.demo.domain.user.Girl;
import com.example.demo.domain.user.Man;
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
    private UserServiceImpl userService;

    @RequestMapping(method = RequestMethod.GET)
    public List<User> getUsers() {
        return userService.getUsers();
    }

    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public User getUserDetails(@PathVariable Long id) {

        return userService.getUserById(id);
    }

    @RequestMapping(value = "/mans", method = RequestMethod.GET)
    public List<Man> getMans() {
        return userService.getMans();
    }

    @RequestMapping(value = "/girls", method = RequestMethod.GET)
    public List<Girl> getGirls() {
        return userService.getGirls();
    }
}
