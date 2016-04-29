package com.bug.tracker.controller.bug;

import com.bug.tracker.controller.AbsController;
import com.bug.tracker.dto.BugReportDto;
import com.bug.tracker.dto.UserDto;
import com.bug.tracker.model.Priority;
import com.bug.tracker.model.Status;
import com.bug.tracker.model.User;
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
public class SaveBugReportController extends AbsController {

    @RequestMapping(value = { "/new-bug-report-{id}" }, method = RequestMethod.GET)
    public String newBugReport(@PathVariable int id, ModelMap model) {
        User reporterUser = userService.findByLogin(getPrincipal());
        BugReportDto bugReportDto = new BugReportDto();
        bugReportDto.setReporterId(reporterUser.getId());
        bugReportDto.setProjectId(id);
        model.addAttribute("bugReportDto", bugReportDto);
        return "newbugreport";
    }
    @RequestMapping(value = "/new-bug-report-{id}", method = RequestMethod.POST)
    public String saveBugReport(BugReportDto bugReportDto, BindingResult result, ModelMap model) {
        bugReportUtils.validate(bugReportDto,result);
        if (result.hasErrors()) {
            model.addAttribute("errorEmpty", "There are errors");
            return "newbugreport";
        }
        bugReportService.save(bugReportDto);
        model.addAttribute("user", getPrincipal());
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
