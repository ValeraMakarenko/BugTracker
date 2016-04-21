package com.bug.tracker.dao;

import com.bug.tracker.model.Priority;

import java.util.List;

public interface PriorityDao {

    List<Priority> findAll();

    Priority findByType(String type);

    Priority findById(int id);
}
