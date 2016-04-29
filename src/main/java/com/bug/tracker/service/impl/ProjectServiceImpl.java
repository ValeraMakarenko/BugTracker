package com.bug.tracker.service.impl;

import com.bug.tracker.dao.ProjectDao;
import com.bug.tracker.dto.ProjectDto;
import com.bug.tracker.mapper.ProjectMapper;
import com.bug.tracker.model.Project;
import com.bug.tracker.model.ProjectForViewKotlin;
import com.bug.tracker.service.ProjectService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("projectService")
@Transactional
public class ProjectServiceImpl implements ProjectService {
    private static final String URL = "Url is not exist";
    private static final Logger log = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private ProjectDao dao;
    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public void updateProject(ProjectDto projectDto) {
        Project project = projectMapper.projectDtoToProject(projectDto);
        Project updateProject = dao.findById(projectDto.getId());
        if (updateProject != null) {
            updateProject.setNameProject(project.getNameProject());
            String str = project.getUrl();
            if (str != null && !str.isEmpty()) {
                updateProject.setUrl(project.getUrl());
            }
            else {
                updateProject.setUrl(URL);
            }
            updateProject.setManager(project.getManager());
            updateProject.setTypeProject(project.getTypeProject());
            log.debug("Updating project '" + projectDto.getNameProject() + "' in db.");
        }
    }

    @Override
    public List<ProjectForViewKotlin> findAll() {
        return projectMapper.ProjectsToProjectForViewKotlins(dao.findAll());
    }

    @Override
    public void deleteProjectById(int id) {
        dao.deleteProjectById(id);
    }

    @Override
    public ProjectDto findById(int id) {
        return projectMapper.projectToProjectDto(dao.findById(id));
    }

    @Override
    public void save(ProjectDto projectDto) {
        Project project = projectMapper.projectDtoToProject(projectDto);
        String str = project.getUrl();
        if (str == null || str.isEmpty()) {
            project.setUrl(URL);
        }
        dao.save(project);
        log.debug("Saving project '" + projectDto.getNameProject() + "' in db.");
    }

}
