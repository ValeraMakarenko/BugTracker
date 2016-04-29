package com.bug.tracker.dao;

import com.bug.tracker.model.Project;

import java.util.List;

public interface ProjectDao {

    void save(Project project);

    Project findById(int id);

    List<Project> findAll();

    void deleteProjectById(int id);

}
