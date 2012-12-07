package org.zhaobudao.mist.repository.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.zhaobudao.mist.jdbc.Template;
import org.zhaobudao.mist.model.Project;
import org.zhaobudao.mist.repository.IProjectRepository;

@Repository
public class ProjectRepository implements IProjectRepository {

    @Autowired
    private Template template;

    @Override
    public List<Project> query(Project project, Class<Project> type) {
        return template.query(project, type);
    }

    @Override
    public int save(Project project) {
        return template.insert(project);
    }

    @Override
    public Project queryForObject(Project project, Class<Project> type) {
        return template.queryForObject(project, type);
    }

    @Override
    public int update(Project where, Project project) {
        return template.update(where, project);
    }

    @Override
    public int delete(Project project) {
        return template.delete(project);
    }
}
