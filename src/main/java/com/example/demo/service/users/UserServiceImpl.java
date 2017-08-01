package com.example.demo.service.users;

import com.example.demo.domain.Girl;
import com.example.demo.domain.Man;
import com.example.demo.domain.User;
import com.example.demo.persistent.user.GirlsRepository;
import com.example.demo.persistent.user.MansRepository;
import com.example.demo.persistent.user.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service // declare this class as @Component - @Service
@Transactional(rollbackFor = Throwable.class)// rollback when exception or error
public class UserServiceImpl implements UserService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

    @Inject
    public UsersRepository usersRepository;

    @Inject
    public MansRepository mansRepository;

    @Inject
    public GirlsRepository girlsRepository;

    @Override
    public List<User> getUsers() {
        return usersRepository.findAll();
    }

    @Override
    public User getUserById(final Long id) {

        return usersRepository.findOne(id);
    }

    @Override
    public List<Man> getMans() {

        return mansRepository.findAll();
    }

    @Override
    public List<Girl> getGirls() {

        return girlsRepository.findAll();
    }
}
