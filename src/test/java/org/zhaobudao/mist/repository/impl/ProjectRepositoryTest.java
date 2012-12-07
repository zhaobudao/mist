package org.zhaobudao.mist.repository.impl;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
import java.util.Date;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zhaobudao.mist.jdbc.Template;
import org.zhaobudao.mist.model.Project;
import org.zhaobudao.mist.repository.impl.ProjectRepository;
import org.zhaobudao.mist.util.ConstantsTest;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(ConstantsTest.CONTEXT)
public class ProjectRepositoryTest {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private Template template;

    @Test
    public void testQuery() {
        Project project = new Project();
        List<Project> projects = projectRepository.query(project, Project.class);
        int count = template.queryForInt("select count(id) from project");
        assertThat(projects.size(), is(count));

        Project p = new Project();
        p.setAbbr("abbrsjlfiefsjfjoseilfslf");
        projects = projectRepository.query(p, Project.class);
        assertThat(projects.size(), is(0));
    }

    @Test
    public void testSave() {
        Project project = new Project();
        project.setAbbr("abbr");
        project.setCreateBy(-1);
        project.setCreateDate(new Date());
        int i = projectRepository.save(project);
        int id = template.queryForInt("select max(id) + 1 from project");
        assertThat(projectRepository.save(project), is(id));
        project.setId(id);
        Project delete = new Project();
        delete.setId(i);
        projectRepository.delete(delete);
        Project pr = new Project();
        pr.setId(id);
        projectRepository.delete(pr);
    }

    @Test
    public void testQueryForObject() {
        Project project = new Project();
        project.setAbbr("abbr");
        project.setCreateBy(-1);
        project.setCreateDate(new Date());
        Project p = new Project();
        p.setId(projectRepository.save(project));
        assertNotNull(projectRepository.queryForObject(p, Project.class));
        projectRepository.delete(p);
    }

    @Test
    public void testUpdate() {
        Project where = new Project();
        where.setId(Integer.MAX_VALUE);
        Project project = new Project();
        project.setAbbr("aa");
        project.setName("bbbb");
        assertThat(projectRepository.update(where, project), is(0));
    }

    @Test
    public void testDelete() {
        Project project = new Project();
        project.setId(Integer.MAX_VALUE);
        assertThat(projectRepository.delete(project), is(0));
    }

}
