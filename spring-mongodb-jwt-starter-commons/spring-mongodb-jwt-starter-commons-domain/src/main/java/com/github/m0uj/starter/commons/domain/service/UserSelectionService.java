package com.github.m0uj.starter.commons.domain.service;

import com.github.m0uj.starter.commons.storage.pojo.User;

/**
 * Created by m0uj on 4/18/17.
 */
public interface UserSelectionService {
    public User selectByUsername(String username);
}
