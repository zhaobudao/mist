package org.zhaobudao.mist.repository;

import java.util.List;

import org.zhaobudao.mist.model.Project;


public interface IProjectRepository {

    List<Project> query(Project project, Class<Project> type);

    int save(Project project);

    Project queryForObject(Project project, Class<Project> type);

    int update(Project where, Project project);

    int delete(Project project);

}
