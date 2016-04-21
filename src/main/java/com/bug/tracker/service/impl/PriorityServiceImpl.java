package com.bug.tracker.service.impl;

import com.bug.tracker.dao.PriorityDao;
import com.bug.tracker.model.Priority;
import com.bug.tracker.service.PriorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("priorityService")
@Transactional
public class PriorityServiceImpl implements PriorityService {

    @Autowired
    PriorityDao dao;

    @Override
    public List<Priority> findAll() {
        return dao.findAll();
    }

    @Override
    public Priority findByType(String type) {
        return dao.findByType(type);
    }

    @Override
    public Priority findById(int id) {
        return dao.findById(id);
    }
}
