package com.bug.tracker.mapper.Impl;

import com.bug.tracker.dto.UserDto;
import com.bug.tracker.mapper.UserMapper;
import com.bug.tracker.model.User;
import com.bug.tracker.model.UserProfile;
import com.bug.tracker.service.UserProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapperImpl implements UserMapper {

    @Autowired
    private UserProfileService userProfileService;

    @Override
    public UserDto userToUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setEmail(user.getEmail());
        UserProfile userProfile = user.getUserProfile();
        userDto.setIdRole(userProfile.getId());
        return userDto;
    }

    @Override
    public User userDtoToUser(UserDto userDto) {
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setPassword(userDto.getPassword());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setEmail(userDto.getEmail());
        UserProfile userProfile = userProfileService.findById(userDto.getIdRole());
        user.setUserProfile(userProfile);
        return user;
    }

    @Override
    public List<User> userDtosToUsers(List<UserDto> userDtoList) {
        if (userDtoList == null) {
            return null;
        }
        List<User> users = new ArrayList<>();
        for (UserDto userDto : userDtoList) {
            users.add(userDtoToUser(userDto));
        }
        return users;
    }

    @Override
    public List<UserDto> usersToUserDtos(List<User> userList) {
        if (userList == null) {
            return null;
        }
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : userList) {
            userDtos.add(userToUserDto(user));
        }
        return userDtos;
    }
}
