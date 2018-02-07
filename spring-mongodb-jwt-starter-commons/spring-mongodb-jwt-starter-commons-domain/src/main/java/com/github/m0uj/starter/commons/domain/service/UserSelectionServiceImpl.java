package com.github.m0uj.starter.commons.domain.service;

import com.github.m0uj.starter.commons.storage.dao.UserRepository;
import com.github.m0uj.starter.commons.storage.pojo.User;
import org.springframework.stereotype.Service;

/**
 * Created by m0uj on 4/18/17.
 */
@Service
public class UserSelectionServiceImpl implements UserSelectionService {
    private final UserRepository userRepository;

    public UserSelectionServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User selectByUsername(String username) {
        return userRepository.findOneByUsername(username);
    }
}
