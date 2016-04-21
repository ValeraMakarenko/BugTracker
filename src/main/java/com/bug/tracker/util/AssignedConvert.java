package com.bug.tracker.util;

import com.bug.tracker.model.User;
import com.bug.tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class AssignedConvert implements Converter<Object, User> {

    @Autowired
    UserService userService;

    public User convert(Object element) {
        Integer id = null;
        try {
            id = Integer.parseInt((String)element);
        } catch (NumberFormatException e) {
            return (User)element;
        }
        User user = userService.findById(id);
        System.out.println("User : "+user);
        return user;
    }
}
