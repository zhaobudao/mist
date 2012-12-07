package org.zhaobudao.mist.controller;

import static org.springframework.test.web.server.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.server.result.MockMvcResultMatchers.*;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.web.server.MockMvc;
import org.springframework.test.web.server.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.zhaobudao.mist.loader.WebContextLoader;
import org.zhaobudao.mist.model.Project;
import org.zhaobudao.mist.service.ProjectService;
import org.zhaobudao.mist.util.Constants;
import org.zhaobudao.mist.util.ConstantsTest;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = WebContextLoader.class, locations = { ConstantsTest.CONTEXT, ConstantsTest.SERVLET_CONTEXT })
@TransactionConfiguration
public class ProjectControllerTest {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private ProjectService projectService;

    private MockMvc mvc;

    private int id;

    @Before
    @Transactional
    public void setUp() throws Exception {
        this.mvc = MockMvcBuilders.webApplicationContextSetup(this.wac).build();
        Project project = new Project();
        project.setName("name");
        project.setAbbr("abbr");
        project.setCreateBy(-1);
        project.setCreateDate(new Date());
        id = projectService.save(project);
    }

    @Test
    @Transactional
    public void testList() throws Exception {
        mvc.perform(get("/project")).andExpect(status().isOk()).andExpect(model().attributeExists("projects")).andExpect(view().name("project/list"));
    }

    @Test
    @Transactional
    public void testShow() throws Exception {
        mvc.perform(get("/project/" + id)).andExpect(status().isOk()).andExpect(model().attributeExists("project")).andExpect(view().name("project/show"));
    }

    @Test
    @Transactional
    public void testCreate() throws Exception {
        mvc.perform(get("/project/create")).andExpect(status().isOk()).andExpect(view().name("project/create"));
    }

    @Test
    @Transactional
    public void testCreateProjectBindingResultUser() throws Exception {
        mvc.perform(post("/project/create").sessionAttr(Constants.SESSION_USER, ConstantsTest.USER)).andExpect(status().isOk())
                .andExpect(model().attributeHasFieldErrors("project", "name", "abbr")).andExpect(redirectedUrl(""));
        mvc.perform(post("/project/create").sessionAttr(Constants.SESSION_USER, ConstantsTest.USER).param("name", "sssname").param("abbr", "ssssabbr")).andExpect(status().isOk())
                .andExpect(redirectedUrl("" + (id + 1)));
    }

    @Test
    @Transactional
    public void testModifyIntProjectModel() throws Exception {
        mvc.perform(get("/project/" + id + "/modify")).andExpect(status().isOk()).andExpect(model().attributeExists("project")).andExpect(view().name("project/modify"));
    }

    @Test
    @Transactional
    public void testModifyIntProjectBindingResultUser() throws Exception {
        mvc.perform(post("/project/" + id + "/modify").sessionAttr(Constants.SESSION_USER, ConstantsTest.USER)).andExpect(status().isOk())
                .andExpect(model().attributeHasFieldErrors("project", "name", "abbr")).andExpect(redirectedUrl(""));
        mvc.perform(post("/project/" + id + "/modify").sessionAttr(Constants.SESSION_USER, ConstantsTest.USER).param("name", "sssname").param("abbr", "ssssabbr"))
                .andExpect(status().isOk()).andExpect(redirectedUrl("" + (id)));
    }

    @Test
    @Transactional
    public void testDelete() throws Exception {
        mvc.perform(get("/project/" + id + "/delete")).andExpect(status().isOk()).andExpect(redirectedUrl("../"));
    }

}
