package org.zhaobudao.mist.model;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.zhaobudao.mist.model.Project;

public class ProjectTest {

    private Project project;

    @Before
    public void setUp() throws Exception {
        project = new Project();
    }

    @Test
    public void testProject() {
        project.getId();
        project.getAbbr();
        project.getCreateBy();
        project.getCreateDate();
        project.getModifyBy();
        project.getModifyDate();
        project.getName();

        project.setId(1);
        project.setAbbr("a");
        project.setCreateBy(-1);
        project.setCreateDate(new Date());
        project.setModifyBy(-1);
        project.setModifyDate(new Date());
        project.setName("name");
    }

}
