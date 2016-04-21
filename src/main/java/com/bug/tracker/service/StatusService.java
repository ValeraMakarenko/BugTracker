package com.bug.tracker.service;

import com.bug.tracker.model.Status;

import java.util.List;

public interface StatusService {

    List<Status> findAll();

    Status findByType(String type);

    Status findById(int id);
}
