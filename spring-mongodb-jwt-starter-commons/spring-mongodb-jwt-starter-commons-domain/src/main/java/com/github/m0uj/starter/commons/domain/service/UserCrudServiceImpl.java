package com.github.m0uj.starter.commons.domain.service;

import com.github.m0uj.starter.commons.storage.dao.UserRepository;
import com.github.m0uj.starter.commons.storage.pojo.User;
import org.springframework.stereotype.Service;

/**
 * Created by m0uj on 4/18/17.
 */
@Service
public class UserCrudServiceImpl implements UserCrudService {
    private final UserRepository userRepository;

    public UserCrudServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User read(String id) {
        return userRepository.findById(id);
    }
}
