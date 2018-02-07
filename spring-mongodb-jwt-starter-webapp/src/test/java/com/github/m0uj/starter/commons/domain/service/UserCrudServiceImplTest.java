package com.github.m0uj.starter.commons.domain.service;

import com.github.m0uj.starter.commons.storage.dao.UserRepository;
import com.github.m0uj.starter.commons.storage.pojo.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;

/**
 * Created by m0uj on 5/23/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserCrudServiceImplTest{
    @MockBean
    private UserRepository userRepository;

    @Autowired
    private UserCrudService userCrudService;
    private User user0;

    @Before
    public void setUp() throws Exception {
        user0 = new User();
        user0.setId("user0 id");
    }
    @Test
    public void createTest() throws Exception {
        given(this.userRepository.save(user0)).willReturn(user0);
        assertThat(userCrudService.create(user0),is(user0));
    }
    @Test
    public void readTest() throws Exception {
        given(this.userRepository.findById(user0.getId())).willReturn(user0);
        assertThat(userCrudService.read(user0.getId()),is(userRepository.findById("user0 id")));
    }

}