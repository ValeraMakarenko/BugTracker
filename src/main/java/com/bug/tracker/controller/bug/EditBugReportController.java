package com.bug.tracker.controller.bug;

import com.bug.tracker.controller.AbsController;
import com.bug.tracker.dto.BugReportDto;
import com.bug.tracker.dto.UserDto;
import com.bug.tracker.model.Priority;
import com.bug.tracker.model.Status;
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
public class EditBugReportController extends AbsController {

    @RequestMapping(value = { "/edit-bugreport-{id}" }, method = RequestMethod.GET)
    public String editBugReport(@PathVariable int id, ModelMap model) {
        BugReportDto bugReportDto = bugReportService.findById(id);
        model.addAttribute("bugReportDto", bugReportDto);
        model.addAttribute("edit", true);
        return "editbugreport";
    }

    @RequestMapping(value = { "/edit-bugreport-{id}" }, method = RequestMethod.POST)
    public String updateBugReport(BugReportDto bugReportDto, BindingResult result, ModelMap model) {
        bugReportUtils.validate(bugReportDto,result);
        if (result.hasErrors()) {
            model.addAttribute("errorEmpty", "There are errors");
            return "editbugreport";
        }
        bugReportService.updateBugReport(bugReportDto);
        return "redirect:/home";
    }

    @ModelAttribute("statuses")
    public List<Status> initializeStatuses() {
        return statusService.findAll();
    }

    @ModelAttribute("priorities")
    public List<Priority> initializeProfiles() {
        return priorityService.findAll();
    }

    @ModelAttribute("assignedId")
    public List<UserDto> initializeUsers() {
        List<UserDto> assignedUsers = new ArrayList<>();
        List<UserDto> allUsers = userService.findAll();
        for(UserDto user : allUsers) {
            int roleId = user.getIdRole();
            if (roleId != 3){
                assignedUsers.add(user);
            }
        }
        return assignedUsers;
    }

    @ModelAttribute("reporterId")
    public List<UserDto> initializeUsers2() {
        return userService.findAll();
    }
}
