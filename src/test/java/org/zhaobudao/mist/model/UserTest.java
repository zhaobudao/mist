package org.zhaobudao.mist.model;

import org.junit.Before;
import org.junit.Test;
import org.zhaobudao.mist.model.User;
import org.zhaobudao.mist.util.Constants;


public class UserTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User();
    }

    @Test
    public void testUser() {
        user.getId();
        user.getEmail();
        user.getPassword();
        user.getUsername();
        user.getSalt();
        user.setId(1);
        user.setEmail("111");
        user.setPassword("111");
        user.setUsername("username");
        user.setSalt(Constants.SALT);
    }

}
