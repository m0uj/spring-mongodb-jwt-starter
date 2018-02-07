package com.github.m0uj.starter.commons.storage.dao;

import com.github.m0uj.starter.commons.storage.pojo.User;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by m0uj on 3/28/17.
 */
@Transactional
public interface UserRepository extends AbstractPojoBaseRepository<User> {
    public User findOneByUsername(String username);
}
