package com.bug.tracker.service.impl;

import com.bug.tracker.dao.UserDao;
import com.bug.tracker.model.User;
import com.bug.tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao dao;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public boolean save(User user){
        User ifUserNotNull = findByLogin(user.getLogin());
        if (ifUserNotNull != null){
            return false;
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        dao.save(user);
        return true;
    }

    public User findById(int id) {
        return dao.findById(id);
    }

    public User findByLogin(String login) {
        return dao.findByLogin(login);
    }

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

}
