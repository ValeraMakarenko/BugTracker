package com.bug.tracker.controller;

import com.bug.tracker.dto.BugReportDto;
import com.bug.tracker.dto.UserDto;
import com.bug.tracker.model.BugReportForViewKotlin;
import com.bug.tracker.model.Priority;
import com.bug.tracker.model.Status;
import com.bug.tracker.model.User;
import com.bug.tracker.service.BugReportService;
import com.bug.tracker.service.PriorityService;
import com.bug.tracker.service.StatusService;
import com.bug.tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
class BugReportController {

    @Autowired
    private StatusService statusService;
    @Autowired
    private PriorityService priorityService;
    @Autowired
    private UserService userService;
    @Autowired
    private BugReportService bugReportService;

    @RequestMapping(value = "/bugreportlist", method = RequestMethod.GET)
    public String bugReportList(ModelMap model) {
        List<BugReportForViewKotlin> bugReportForViewKotlins = bugReportService.findAll();
        model.addAttribute("bugReports", bugReportForViewKotlins);
        return "bugreportlist";
    }

    @RequestMapping(value = { "/delete-bugreport-{id}" }, method = RequestMethod.GET)
    public String deleteBugReport(@PathVariable int id) {
        bugReportService.deleteBugReportById(id);
        return "redirect:/bugreportlist";
    }

    @RequestMapping(value = { "/edit-bugreport-{id}" }, method = RequestMethod.GET)
    public String editBugReport(@PathVariable int id, ModelMap model) {
        BugReportDto bugReportDto = bugReportService.findById(id);
        model.addAttribute("bugReport", bugReportDto);
        model.addAttribute("edit", true);
        return "editbugreport";
    }

    @RequestMapping(value = { "/edit-bugreport-{id}" }, method = RequestMethod.POST)
    public String updateBugReport(@Valid BugReportDto bugReportDto, ModelMap model) {
        bugReportService.updateBugReport(bugReportDto);
        return "redirect:/bugreportlist";
    }

    @RequestMapping(value = "/newBugReport", method = RequestMethod.GET)
    public String newBugReport(ModelMap model) {
        User reporterUser = userService.findByLogin(getPrincipal());
        BugReportDto bugReportDto = new BugReportDto();
        bugReportDto.setReporterId(reporterUser.getId());
        model.addAttribute("bugReport", bugReportDto);
        return "newbugreport";
    }
    @RequestMapping(value = "/newBugReport", method = RequestMethod.POST)
    public String saveBugReport(@Valid BugReportDto bugReportDto, ModelMap model) {
        /*if (!BugReportUtils.validateBugReport(bugReportDto)) {
            System.out.println("There are errors");
            return "newBugReport";
        }*/
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
