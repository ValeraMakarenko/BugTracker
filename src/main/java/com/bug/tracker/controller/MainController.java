package com.bug.tracker.controller;

import com.bug.tracker.model.User;
import com.bug.tracker.model.UserProfile;
import com.bug.tracker.service.UserProfileService;
import com.bug.tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    UserProfileService userProfileService;

    @Autowired
    UserService userService;

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
        User user = new User();
        model.addAttribute("user", user);
        return "newuser";
    }


    @RequestMapping(value = "/newUser", method = RequestMethod.POST)
    public String saveRegistration(@Valid User user,
                                   BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            System.out.println("There are errors");
            return "newuser";
        }
        boolean isUnique = userService.save(user);
        if (!isUnique) {
            model.addAttribute("error", "Enter another login!");
            return "newuser";
        }

        System.out.println("First Name : " + user.getFirstName());
        System.out.println("Last Name : " + user.getLastName());
        System.out.println("Login : " + user.getLogin());
        System.out.println("Password : " + user.getPassword());
        System.out.println("Email : " + user.getEmail());
        System.out.println("Checking UsrProfiles....");
        if (user.getUserProfiles() != null) {
            for (UserProfile profile : user.getUserProfiles()) {
                System.out.println("Profile : " + profile.getRole());
            }
        }

        model.addAttribute("success", "User " + user.getFirstName() + " has been registered successfully");
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(user.getLogin(), user.getPassword());
        Authentication authentication = token;
        SecurityContextHolder.getContext().setAuthentication(authentication);
        model.addAttribute("user", getPrincipal());
        return "redirect:/home";
    }

    @ModelAttribute("roles")
    public List<UserProfile> initializeProfiles() {
        return userProfileService.findAll();
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

}
