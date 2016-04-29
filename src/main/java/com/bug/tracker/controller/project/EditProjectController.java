package com.bug.tracker.controller.project;

import com.bug.tracker.controller.AbsController;
import com.bug.tracker.dto.ProjectDto;
import com.bug.tracker.dto.TypeProjectDto;
import com.bug.tracker.dto.UserDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EditProjectController extends AbsController {
    private static final String URL = "Url is not exist";

    @RequestMapping(value = { "/edit-project-{id}" }, method = RequestMethod.GET)
    public String editProject(@PathVariable int id, ModelMap model) {
        ProjectDto projectDto = projectService.findById(id);
        if (URL.equalsIgnoreCase(projectDto.getUrl())) {
            projectDto.setUrl("");
        }
        model.addAttribute("projectDto", projectDto);
        model.addAttribute("edit", true);
        return "editproject";
    }

    @RequestMapping(value = { "/edit-project-{id}" }, method = RequestMethod.POST)
    public String updateProject(ProjectDto projectDto, BindingResult result, ModelMap model) {
        projectUtils.validate(projectDto,result);
        if (result.hasErrors()) {
            model.addAttribute("errorEmpty", "There are errors");
            return "editproject";
        }
        projectService.updateProject(projectDto);
        return "redirect:/projectlist";
    }

    @ModelAttribute("typeProjects")
    public List<TypeProjectDto> initializeStatuses() {
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
