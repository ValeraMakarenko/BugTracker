package com.bug.tracker.controller;

import com.bug.tracker.dto.UserDto;
import com.bug.tracker.model.UserProfile;
import com.bug.tracker.service.UserProfileService;
import com.bug.tracker.service.UserService;
import com.bug.tracker.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserProfileService userProfileService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String homePage(ModelMap model) {
        model.addAttribute("greeting", "Hi, Welcome to mysite");
        return "welcome";
    }

    @RequestMapping(value = {"/header"}, method = RequestMethod.GET)
    public String header(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "header";
    }

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String accPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "account";
    }

    @RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
    public String accessDeniedPage(ModelMap model) {
        model.addAttribute("user", getPrincipal());
        return "accessDenied";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";
    }


    @RequestMapping(value = "/newUser", method = RequestMethod.GET)
    public String newRegistration(ModelMap model) {
        UserDto userDto = new UserDto();
        model.addAttribute("userDto", userDto);
        return "newuser";
    }

    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String saveRegistration(@Valid UserDto userDto, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            System.out.println("There are errors");
            model.addAttribute("errorEmpty", "There are errors");
            return "newuser";
        }
        if (!UserUtils.validateUser(userDto)) {
            System.out.println("There are errors");
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

    private String getPrincipal() {
        String userName;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}
