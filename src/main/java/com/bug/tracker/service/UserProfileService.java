package com.bug.tracker.service;

import com.bug.tracker.model.UserProfile;

import java.util.List;

public interface UserProfileService {

    List<UserProfile> findAll();

    UserProfile findByRole(String role);

    UserProfile findById(int id);

}
