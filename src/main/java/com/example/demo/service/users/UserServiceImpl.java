package com.example.demo.service.users;

import com.example.demo.domain.user.Girl;
import com.example.demo.domain.user.Man;
import com.example.demo.domain.user.User;
import com.example.demo.persistent.user.GirlsRepository;
import com.example.demo.persistent.user.MansRepository;
import com.example.demo.persistent.user.UsersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import java.util.List;

@Service
@Transactional(rollbackFor = Throwable.class)// rollback when exception or error
public class UserServiceImpl implements UserService {

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
