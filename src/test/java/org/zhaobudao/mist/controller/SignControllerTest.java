package org.zhaobudao.mist.controller;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.zhaobudao.mist.loader.WebContextLoader;
import org.zhaobudao.mist.util.ConstantsTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = WebContextLoader.class, locations = { ConstantsTest.CONTEXT, ConstantsTest.SERVLET_CONTEXT })
@TransactionConfiguration
public class SignControllerTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mvc;

    @Before
    public void setUp() {
        this.mvc = MockMvcBuilders.webApplicationContextSetup(this.wac).build();
    }

    @Test
    public void testSignin() throws Exception {
        mvc.perform(post("/signin").param("email", "email@email.com").param("password", "password")).andExpect(status().isOk()).andExpect(redirectedUrl("/"));
        mvc.perform(post("/signin").param("email", "email@email.com").param("password", "email@email.com")).andExpect(status().isOk()).andExpect(redirectedUrl("/"));
    }

    @Test
    public void testSigninValid() throws Exception {
        mvc.perform(post("/signin").param("email", "email@email.com")).andExpect(status().isOk()).andExpect(model().attributeHasFieldErrors("user", "password"));
        mvc.perform(post("/signin").param("email", "gaoyang_auto@yonyou.com").param("password", "123456")).andExpect(status().isOk());
    }

    @Test
    public void testCookie() throws Exception {
        mvc.perform(get("/cookie")).andExpect(status().isOk());
    }

}
