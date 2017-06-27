package com.example.demo.representation;

import com.example.demo.domain.user.Girl;
import com.example.demo.domain.user.Man;
import com.example.demo.domain.user.User;
import com.example.demo.service.users.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

@RestController // means @Controller +  ResponseBody with all methods
@RequestMapping("/api/users")// url mapping
public class MainResource {
    private static final Logger LOGGER = LoggerFactory.getLogger(MainResource.class);

    @Inject // inject bean UserService(UserServiceImpl declared as @Service)
    private UserService userService;

    @RequestMapping(method = RequestMethod.GET) // Additional url mapping with specific http method GET
    public List<User> getUsers() {
        return userService.getUsers();
    }

    // Additional url /detail/{id} mapping with specific http method GET. Means: "/api/users" from class + "/detail/{id}" from this method
    @RequestMapping(value = "/detail/{id}", method = RequestMethod.GET)
    public User getUserDetails(@PathVariable Long id) { // Means variable id taken from url in /{id}

        return userService.getUserById(id);
    }

    // Additional url /detail/{id} mapping with specific http method GET. Means: "/api/users" from class + "/mans" from this method
    @RequestMapping(value = "/mans", method = RequestMethod.GET)
    public List<Man> getMans() {
        return userService.getMans();
    }

    // Additional url /detail/{id} mapping with specific http method GET. Means: "/api/users" from class + "/girls" from this method
    @RequestMapping(value = "/girls", method = RequestMethod.GET)
    public List<Girl> getGirls() {
        return userService.getGirls();
    }
}
