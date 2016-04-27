package com.bug.tracker.service;

import com.bug.tracker.dto.UserDto;
import com.bug.tracker.model.User;

import java.util.List;

public interface UserService {

    boolean save(UserDto userDto);

    User findById(int id);

    User findByLogin(String login);

    List<UserDto> findAll();

}
