package com.bug.tracker.service.impl;

import com.bug.tracker.dao.UserProfileDao;
import com.bug.tracker.model.UserProfile;
import com.bug.tracker.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userProfileService")
@Transactional
public class UserProfileServiceImpl implements UserProfileService {

    @Autowired
    UserProfileDao dao;

    @Override
    public List<UserProfile> findAll() {
        return dao.findAll();
    }

    @Override
    public UserProfile findByRole(String role) {
        return dao.findByRole(role);
    }

    @Override
    public UserProfile findById(int id) {
        return dao.findById(id);
    }
}
