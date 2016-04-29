package com.bug.tracker.dao;

import com.bug.tracker.model.TypeProject;

import java.util.List;

public interface TypeProjectDao {

    List<TypeProject> findAll();

    TypeProject findByType(String type);

    TypeProject findById(int id);

    void save(TypeProject typeProject);

}
