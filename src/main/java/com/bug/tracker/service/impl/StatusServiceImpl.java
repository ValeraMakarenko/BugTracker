package com.bug.tracker.service.impl;

import com.bug.tracker.dao.StatusDao;
import com.bug.tracker.model.Status;
import com.bug.tracker.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("statusService")
@Transactional
public class StatusServiceImpl implements StatusService {

    @Autowired
    StatusDao dao;

    @Override
    public List<Status> findAll() {
        return dao.findAll();
    }

    @Override
    public Status findByType(String type) {
        return dao.findByType(type);
    }

    @Override
    public Status findById(int id) {
        return dao.findById(id);
    }
}