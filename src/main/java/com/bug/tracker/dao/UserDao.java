package com.bug.tracker.dao;

import com.bug.tracker.model.User;

import java.util.List;

public interface UserDao {

    void save(User user);

    User findById(int id);

    User findByLogin(String login);

    List<User> findAll();

}
