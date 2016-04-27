package com.bug.tracker.mapper;

import com.bug.tracker.dto.UserDto;
import com.bug.tracker.model.User;

import java.util.List;

public interface UserMapper {

    UserDto userToUserDto(User user);

    User userDtoToUser(UserDto userDto);

    List<User> userDtosToUsers (List<UserDto> userDtoList);

    List<UserDto> usersToUserDtos(List<User> userList);

}
