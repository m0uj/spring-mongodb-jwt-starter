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
public class UserSelectionServiceImplTest{
    @MockBean
    private UserRepository userRepository;
    @Autowired
    private UserSelectionService userSelectionService;
    private User user0;
    @Before
    public void setUp() throws Exception {
        user0 = new User();
        user0.setUsername("user0");
    }
    @Test
    public void selectByUsername() throws Exception {
        given(this.userRepository.findOneByUsername(user0.getUsername())).willReturn(user0);
        assertThat(userSelectionService.selectByUsername(user0.getUsername()),is(user0));
    }

}