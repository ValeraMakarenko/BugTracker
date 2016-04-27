package com.bug.tracker.util;

import com.bug.tracker.dto.UserDto;

public class UserUtils {

    private UserUtils() {
        throw new AssertionError("Class contains static methods only. You should not instantiate it!");
    }

    public static boolean validateUser(UserDto userDto) {
        String login = userDto.getLogin().trim();
        String password = userDto.getPassword().trim();
        String firstName = userDto.getFirstName().trim();
        String lastName = userDto.getLastName().trim();
        String email = userDto.getEmail().trim();

        return !(login.isEmpty() || password.isEmpty() || firstName.isEmpty()
                || lastName.isEmpty() || email.isEmpty());

    }

}
