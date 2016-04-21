package com.bug.tracker.controller;

import com.bug.tracker.model.*;
import com.bug.tracker.service.BugReportService;
import com.bug.tracker.service.PriorityService;
import com.bug.tracker.service.StatusService;
import com.bug.tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Controller
public class BugReportController {

    @Autowired
    StatusService statusService;

    @Autowired
    PriorityService priorityService;

    @Autowired
    UserService userService;

    @Autowired
    BugReportService bugReportService;


    @RequestMapping(value = "/newBugReport", method = RequestMethod.GET)
    public String newBugReport(ModelMap model) {
        BugReport bugReport = new BugReport();
        model.addAttribute("bugReport", bugReport);
        return "newbugreport";
    }

    @RequestMapping(value = "/bugreportlist", method = RequestMethod.GET)
    public String bugReportList(ModelMap model) {
        List<BugReport> bugReports = bugReportService.findAll();
        List<BugReportForViewKotlin> bugReportForViewKotlinList = new ArrayList<>();
        BugReportForViewKotlin bugReportForViewKotlin;
        for (BugReport bugReport : bugReports) {
            bugReportForViewKotlin = convertToBugReportForViewKotlin(bugReport);
            bugReportForViewKotlinList.add(bugReportForViewKotlin);
        }
        model.addAttribute("bugReports", bugReportForViewKotlinList);
        return "bugreportlist";
    }


    @RequestMapping(value = { "/delete-bugreport-{id}" }, method = RequestMethod.GET)
    public String deleteBugReport(@PathVariable int id) {
        bugReportService.deleteBugReportById(id);
        return "redirect:/bugreportlist";
    }

    @RequestMapping(value = { "/edit-bugreport-{id}" }, method = RequestMethod.GET)
    public String editUser(@PathVariable int id, ModelMap model) {
        BugReport bugReport = bugReportService.findById(id);
        model.addAttribute("bugReport", bugReport);
        model.addAttribute("edit", true);
        return "editbugreport";
    }

    @RequestMapping(value = { "/edit-bugreport-{id}" }, method = RequestMethod.POST)
    public String updateUser(@RequestParam("title") String title,
                             @RequestParam("summary") String summary,
                             @RequestParam("stepsToReproduce") String stepsToReproduce,
                             @RequestParam("actualResult") String actualResult,
                             @RequestParam("expectedResult")String expectedResult,
                             @RequestParam("assignedId") Integer assignedId,
                             @RequestParam("statuses") Set<Status> statuses,
                             @RequestParam("priorities") Set<Priority> priorities,
                             @RequestParam("id") int id,
                             @RequestParam("date") LocalDateTime date,
                             @RequestParam("reporterId") Integer reporterId,
                             ModelMap model) {
        User reporterUser = userService.findById(reporterId);
        User assignedUser = userService.findById(assignedId);

        bugReportService.updateBugReport(title, summary, stepsToReproduce, actualResult, expectedResult, assignedUser, statuses, priorities, reporterUser, id, date);

        System.out.println("title : " + title);
        System.out.println("summary : " + summary);
        System.out.println("stepsToReproduce : " + stepsToReproduce);
        System.out.println("actualResult : " + actualResult);
        System.out.println("expectedResult : " + expectedResult);
        System.out.println("assignedUser : " + assignedId);
        System.out.println("assignedUser : " + assignedUser);
        System.out.println("statuses : " + statuses);
        System.out.println("priorities : " + priorities);
        System.out.println("reporterUser : " + reporterUser);
        System.out.println("date : " + date);
        System.out.println("id : " + id);

        //model.addAttribute("success", "User " + user.getFirstName() + " "+ user.getLastName() + " updated successfully");
        return "redirect:/bugreportlist";
    }

    @RequestMapping(value = "/newBugReport", method = RequestMethod.POST)
    public String preSaveBugReport(@RequestParam("title") String title,
                                   @RequestParam("summary") String summary,
                                   @RequestParam("stepsToReproduce") String stepsToReproduce,
                                   @RequestParam("actualResult") String actualResult,
                                   @RequestParam("expectedResult")String expectedResult,
                                   @RequestParam("assignedId") Integer assignedId,
                                   @RequestParam("statuses") Set<Status> statuses,
                                   @RequestParam("priorities") Set<Priority> priorities,
                                   ModelMap model) {
        String reporterLogin = getPrincipal();
        User reporterUser = userService.findByLogin(reporterLogin);
        User assignedUser = userService.findById(assignedId);

        System.out.println("title : " + title);
        System.out.println("summary : " + summary);
        System.out.println("stepsToReproduce : " + stepsToReproduce);
        System.out.println("actualResult : " + actualResult);
        System.out.println("expectedResult : " + expectedResult);
        System.out.println("assignedUser : " + assignedId);
        System.out.println("assignedUser : " + assignedUser);
        System.out.println("statuses : " + statuses);
        System.out.println("priorities : " + priorities);
        System.out.println("reporterUser : " + reporterUser);

        bugReportService.save(title, summary, stepsToReproduce, actualResult, expectedResult, assignedUser, statuses, priorities, reporterUser);

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
    public List<User> initializeUsers() {
        List<User> assignedUsers = new ArrayList<>();
        List<User> allUsers = userService.findAll();
        for(User user : allUsers) {
            Set<UserProfile> userProfiles = user.getUserProfiles();
            for(UserProfile userRole : userProfiles) {
                if (!"Tester".equalsIgnoreCase(userRole.getRole()) ){
                    assignedUsers.add(user);
                    break;
                }
            }
        }
        return assignedUsers;
    }

    @ModelAttribute("reporterId")
    public List<User> initializeUsers2() {
        List<User> reporterUsers = userService.findAll();
        return reporterUsers;
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

    private BugReportForViewKotlin convertToBugReportForViewKotlin(BugReport bugReport) {
        Set<Status> statuses;
        Set<Priority> priorities;
        BugReportForViewKotlin bugReportForViewKotlin = new BugReportForViewKotlin();
        bugReportForViewKotlin.setId(bugReport.getId());
        bugReportForViewKotlin.setTitle(bugReport.getTitle());
        bugReportForViewKotlin.setSummary(bugReport.getSummary());
        bugReportForViewKotlin.setStepsToReproduce(bugReport.getStepsToReproduce());
        bugReportForViewKotlin.setActualResult(bugReport.getActualResult());
        bugReportForViewKotlin.setExpectedResult(bugReport.getExpectedResult());
        bugReportForViewKotlin.setReporter(bugReport.getReporterId().getLogin());
        bugReportForViewKotlin.setAssigned(bugReport.getAssignedId().getLogin());
        statuses = bugReport.getStatuses();
        for (Status status : statuses) {
            bugReportForViewKotlin.setStatus(status.getType());
        }
        priorities = bugReport.getPriorities();
        for (Priority priority : priorities) {
            bugReportForViewKotlin.setPriority(priority.getType());
        }
        bugReportForViewKotlin.setDate(bugReport.getDate());
        return bugReportForViewKotlin;
    }

}
