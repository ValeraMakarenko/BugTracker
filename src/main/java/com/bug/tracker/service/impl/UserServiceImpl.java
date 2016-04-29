package com.bug.tracker.service.impl;

import com.bug.tracker.dao.UserDao;
import com.bug.tracker.dto.UserDto;
import com.bug.tracker.mapper.UserMapper;
import com.bug.tracker.model.User;
import com.bug.tracker.service.UserService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    private static final Logger log = Logger.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDao dao;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean save(UserDto userDto){
        User ifUserNotNull = findByLogin(userDto.getLogin());
        if (ifUserNotNull != null){
            log.debug("Login '" + userDto.getLogin() + "' is exist");
            return false;
        }
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        User user = userMapper.userDtoToUser(userDto);
        dao.save(user);
        log.debug("Saving user '" + userDto.getLogin() + "' in db.");
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword());
        Authentication authentication = token;
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return true;
    }

    @Override
    public User findById(int id) {
        return dao.findById(id);
    }

    @Override
    public User findByLogin(String login) throws UsernameNotFoundException {
        return dao.findByLogin(login);
    }

    @Override
    public List<UserDto> findAll() {
        return userMapper.usersToUserDtos(dao.findAll());
    }

}
