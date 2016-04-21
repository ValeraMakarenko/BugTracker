package com.bug.tracker.dao;

import com.bug.tracker.model.UserProfile;

import java.util.List;

public interface UserProfileDao {

    List<UserProfile> findAll();

    UserProfile findByRole(String role);

    UserProfile findById(int id);
}
