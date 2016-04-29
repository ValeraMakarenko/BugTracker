package com.bug.tracker.controller.user;

import com.bug.tracker.controller.AbsController;
import com.bug.tracker.dto.UserDto;
import com.bug.tracker.model.UserProfile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class SaveUserController extends AbsController {

    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public String newRegistration(ModelMap model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "newuser";
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String saveRegistration(UserDto userDto, BindingResult result, ModelMap model) {
        userUtils.validate(userDto, result);
        if (result.hasErrors()) {
            return "newuser";
        }
        boolean isUnique = userService.save(userDto);
        if (!isUnique) {
            model.addAttribute("error", "Enter another login!");
            return "newuser";
        }
        model.addAttribute("user", getPrincipal());
        return "redirect:/home";
    }

    @ModelAttribute("roles")
    public List<UserProfile> initializeProfiles() {
        return userProfileService.findAll();
    }

}
