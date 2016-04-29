package com.bug.tracker.service;

import com.bug.tracker.dto.ProjectDto;
import com.bug.tracker.model.ProjectForViewKotlin;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface ProjectService {

    void updateProject(ProjectDto projectDto);

    List<ProjectForViewKotlin> findAll();

    @Secured("ROLE_Project_Manager")
    void deleteProjectById(int id);

    ProjectDto findById(int id);

    void save(ProjectDto projectDto);
}
