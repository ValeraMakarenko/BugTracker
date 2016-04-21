package com.bug.tracker.dao;

import com.bug.tracker.model.Status;

import java.util.List;

public interface StatusDao {

    List<Status> findAll();

    Status findByType(String type);

    Status findById(int id);

}
