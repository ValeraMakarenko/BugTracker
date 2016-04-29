package com.bug.tracker.mapper.Impl;

import com.bug.tracker.dto.ProjectDto;
import com.bug.tracker.mapper.ProjectMapper;
import com.bug.tracker.model.Project;
import com.bug.tracker.model.ProjectForViewKotlin;
import com.bug.tracker.model.TypeProject;
import com.bug.tracker.model.User;
import com.bug.tracker.service.TypeProjectService;
import com.bug.tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectMapperImpl implements ProjectMapper {

    @Autowired
    private UserService userService;
    @Autowired
    private TypeProjectService typeProjectService;

    @Override
    public ProjectDto projectToProjectDto(Project project) {
        ProjectDto projectDto = new ProjectDto();
        projectDto.setId(project.getId());
        projectDto.setNameProject(project.getNameProject());
        projectDto.setUrl(project.getUrl());
        projectDto.setManagerId(getUserId(project.getManager()));
        projectDto.setTypeProjectId(getTypeProjectId(project.getTypeProject()));

        return projectDto;
    }

    @Override
    public Project projectDtoToProject(ProjectDto projectDto) {
        Project project = new Project();
        project.setId(projectDto.getId());
        project.setNameProject(projectDto.getNameProject());
        project.setUrl(projectDto.getUrl());
        project.setManager(getUserById(projectDto.getManagerId()));
        project.setTypeProject(getTypeProjectById(projectDto.getTypeProjectId()));

        return project;
    }

    @Override
    public List<Project> projectDtosToProjects(List<ProjectDto> projectDtoList) {
        if (projectDtoList == null) {
            return null;
        }
        List<Project> projectList = new ArrayList<>();
        for (ProjectDto userDto : projectDtoList) {
            projectList.add(projectDtoToProject(userDto));
        }
        return projectList;
    }

    @Override
    public List<ProjectDto> projectsToProjectDtos(List<Project> projectList) {
        if (projectList == null) {
            return null;
        }
        List<ProjectDto> projectDtoList = new ArrayList<>();
        for (Project project : projectList) {
            projectDtoList.add(projectToProjectDto(project));
        }
        return projectDtoList;
    }

    @Override
    public ProjectForViewKotlin ProjectToProjectForViewKotlin(Project project) {
        ProjectForViewKotlin projectForViewKotlin = new ProjectForViewKotlin();
        projectForViewKotlin.setId(project.getId());
        projectForViewKotlin.setNameProject(project.getNameProject());
        projectForViewKotlin.setUrl(project.getUrl());
        projectForViewKotlin.setManager(project.getManager().getLogin());
        projectForViewKotlin.setTypeProject(project.getTypeProject().getType());
        return projectForViewKotlin;
    }

    @Override
    public List<ProjectForViewKotlin> ProjectsToProjectForViewKotlins(List<Project> projectList) {
        List<ProjectForViewKotlin> projectForViewKotlinList = new ArrayList<>();
        for (Project project : projectList) {
            projectForViewKotlinList.add(ProjectToProjectForViewKotlin(project));
        }
        return projectForViewKotlinList;
    }

    @Override
    public ProjectForViewKotlin ProjectDtoToProjectForViewKotlin(ProjectDto projectDto) {
        ProjectForViewKotlin projectForViewKotlin = new ProjectForViewKotlin();
        projectForViewKotlin.setId(projectDto.getId());
        projectForViewKotlin.setNameProject(projectDto.getNameProject());
        projectForViewKotlin.setUrl(projectDto.getUrl());
        projectForViewKotlin.setManager(getUserName(projectDto.getManagerId()));
        projectForViewKotlin.setTypeProject(getNameTypeProjectById(projectDto.getTypeProjectId()));
        return projectForViewKotlin;
    }

    @Override
    public List<ProjectForViewKotlin> ProjectDtosToProjectForViewKotlins(List<ProjectDto> projectDtoList) {
        List<ProjectForViewKotlin> projectForViewKotlinList = new ArrayList<>();
        for (ProjectDto projectDto : projectDtoList) {
            projectForViewKotlinList.add(ProjectDtoToProjectForViewKotlin(projectDto));
        }
        return projectForViewKotlinList;
    }

    private User getUserById(int id) {
        return userService.findById(id);
    }

    private int getUserId(User user) {
        return user.getId();
    }

    private int getTypeProjectId(TypeProject typeProject) {
        return typeProject.getId();
    }

    private TypeProject getTypeProjectById(int id) {
        return typeProjectService.findById(id);
    }

    private String getUserName(int id) {
        User user = getUserById(id);
        return user.getLogin();
    }

    private String getNameTypeProjectById(int id) {
        TypeProject typeProject = getTypeProjectById(id);
        return  typeProject.getType();
    }

}
