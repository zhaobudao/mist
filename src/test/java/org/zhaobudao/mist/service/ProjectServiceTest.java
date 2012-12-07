package org.zhaobudao.mist.service;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;
import org.zhaobudao.mist.jdbc.Template;
import org.zhaobudao.mist.model.Project;
import org.zhaobudao.mist.service.ProjectService;
import org.zhaobudao.mist.util.ConstantsTest;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(ConstantsTest.CONTEXT)
@TransactionConfiguration
public class ProjectServiceTest {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private Template template;

    @Test
    public void testQuery() {
        Project project = new Project();
        List<Project> projects = projectService.query(project, Project.class);
        int count = template.queryForInt("select count(id) from project");
        assertThat(projects.size(), is(count));

        Project p = new Project();
        p.setAbbr("abbrsjlfiefsjfjoseilfslf");
        projects = projectService.query(p, Project.class);
        assertThat(projects.size(), is(0));
    }

    @Test
    @Transactional
    public void testSave() {
        Project project = new Project();
        project.setAbbr("abbr");
        project.setCreateBy(-1);
        project.setCreateDate(new Date());
        projectService.save(project);
        int id = template.queryForInt("select max(id) + 1 from project");
        assertThat(projectService.save(project), is(id));
    }

    @Test
    @Transactional
    public void testQueryForObject() {
        Project project = new Project();
        project.setAbbr("abbr");
        project.setCreateBy(-1);
        project.setCreateDate(new Date());
        Project p = new Project();
        p.setId(projectService.save(project));
        assertNotNull(projectService.queryForObject(p, Project.class));
    }

    @Test
    @Transactional
    public void testUpdate() {
        Project where = new Project();
        where.setId(Integer.MAX_VALUE);
        Project project = new Project();
        project.setAbbr("aa");
        project.setName("bbbb");
        assertThat(projectService.update(where, project), is(0));
    }

    @Test
    @Transactional
    public void testDelete() {
        Project project = new Project();
        project.setId(Integer.MAX_VALUE);
        assertThat(projectService.delete(project), is(0));
    }

}
