package com.bug.tracker.service;

import com.bug.tracker.model.User;

import java.util.List;

public interface UserService {

    boolean save(User user);

    User findById(int id);

    User findByLogin(String login);

    List<User> findAll();

}
