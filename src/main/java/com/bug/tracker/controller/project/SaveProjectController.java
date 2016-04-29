package com.bug.tracker.controller.project;

import com.bug.tracker.controller.AbsController;
import com.bug.tracker.dto.ProjectDto;
import com.bug.tracker.dto.TypeProjectDto;
import com.bug.tracker.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SaveProjectController extends AbsController {

    @RequestMapping(value = "/newProject", method = RequestMethod.GET)
    public String newProject(ModelMap model) {
        ProjectDto projectDto = new ProjectDto();
        model.addAttribute("projectDto", projectDto);
        return "newproject";
    }

    @RequestMapping(value = "/newProject", method = RequestMethod.POST)
    public String saveProject(ProjectDto projectDto, BindingResult result, ModelMap model) {
        projectUtils.validate(projectDto,result);
        if (result.hasErrors()) {
            model.addAttribute("errorEmpty", "There are errors");
            return "newproject";
        }
        projectService.save(projectDto);
        model.addAttribute("user", getPrincipal());
        return "redirect:/home";
    }

    @ModelAttribute("typeProjects")
    public List<TypeProjectDto> initializeTypeProjects() {
        return typeProjectService.findAll();
    }

    @ModelAttribute("managers")
    public List<UserDto> initializeUsers() {
        List<UserDto> assignedUsers = new ArrayList<>();
        List<UserDto> allUsers = userService.findAll();
        for(UserDto user : allUsers) {
            int roleId = user.getIdRole();
            if (roleId != 3 && roleId != 2){
                assignedUsers.add(user);
            }
        }
        return assignedUsers;
    }

}
