package com.github.m0uj.starter.commons.storage.dao;

import com.github.m0uj.starter.commons.storage.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * Created by m0uj on 5/5/17.
 */
@RunWith(SpringRunner.class)
//@SpringBootTest //include to use the same configuration used in WebApplication
@DataMongoTest  //configure an in-memory embedded MongoDB, MongoTemplate and scan for @Document classes
public class UserRepositoryIntegrationTests {
    @Autowired
    protected UserRepository userRepository;

    User user1;

    List<User> all;

    @Before
    public void setUp() throws Exception {
        userRepository.deleteAll();

        user1 = new User();
        user1.setUsername("test");
        user1.setId("1");

        all = userRepository.save(Arrays.asList(user1));
    }

    @Test
    public void findsUserById() throws Exception {
        assertThat(userRepository.findById(user1.getId().toString()), is(user1));
    }

    @Test
    public void findsOneByUsername() throws Exception {
        assertThat(userRepository.findOneByUsername(user1.getUsername().toString()), is(user1));
    }
}