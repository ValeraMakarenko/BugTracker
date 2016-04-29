package com.bug.tracker.mapper;

import com.bug.tracker.dto.ProjectDto;
import com.bug.tracker.model.Project;
import com.bug.tracker.model.ProjectForViewKotlin;

import java.util.List;

public interface ProjectMapper {

    ProjectDto projectToProjectDto(Project project);

    Project projectDtoToProject(ProjectDto projectDto);

    List<Project> projectDtosToProjects (List<ProjectDto> projectDtoList);

    List<ProjectDto> projectsToProjectDtos(List<Project> projectList);

    ProjectForViewKotlin ProjectToProjectForViewKotlin(Project project);

    List<ProjectForViewKotlin> ProjectsToProjectForViewKotlins(List<Project> projectList);

    ProjectForViewKotlin ProjectDtoToProjectForViewKotlin(ProjectDto projectDto);

    List<ProjectForViewKotlin> ProjectDtosToProjectForViewKotlins(List<ProjectDto> projectDtoList);
}
