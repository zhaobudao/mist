package org.zhaobudao.mist.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zhaobudao.mist.model.Project;
import org.zhaobudao.mist.repository.IProjectRepository;

@Service
public class ProjectService {

    @Autowired
    private IProjectRepository projectRepository;

    @Transactional(readOnly = true)
    public List<Project> query(Project project, Class<Project> type) {
        return projectRepository.query(project, type);
    }

    @Transactional
    public int save(Project project) {
        return projectRepository.save(project);
    }

    @Transactional(readOnly = true)
    public Project queryForObject(Project project, Class<Project> type) {
        return projectRepository.queryForObject(project, type);
    }

    @Transactional
    public int update(Project where, Project project) {
        return projectRepository.update(where, project);
    }

    @Transactional
    public int delete(Project project) {
        return projectRepository.delete(project);
    }
}
