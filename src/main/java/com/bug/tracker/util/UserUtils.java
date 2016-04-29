package com.bug.tracker.util;

import com.bug.tracker.dto.UserDto;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserUtils  implements Validator {
    public boolean supports(Class<?> clazz) {
        return UserDto.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;

        userDto.setLogin(userDto.getLogin().trim());
        userDto.setPassword(userDto.getPassword().trim());
        userDto.setFirstName(userDto.getFirstName().trim());
        userDto.setLastName(userDto.getLastName().trim());
        userDto.setEmail(userDto.getEmail().trim());

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "login.empty");
        String login = userDto.getLogin();
        if ((login.length()) > 20) {
            errors.rejectValue("login", "login.tooLong");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty");
        String password = userDto.getPassword();
        if ((password.length()) < 4) {
            errors.rejectValue("password", "password.tooShort");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.empty");
        String firstName = userDto.getFirstName();
        if ((firstName.length()) > 20) {
            errors.rejectValue("firstName", "firstName.tooLong");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "lastName.empty");
        String lastName = userDto.getLastName();
        if ((lastName.length()) > 30) {
            errors.rejectValue("lastName", "lastName.tooLong");
        }

        if( !EmailValidator.getInstance().isValid( userDto.getEmail() ) ){
            errors.rejectValue("email", "email.notValid");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "idRole", "idRole.empty");

    }

}
