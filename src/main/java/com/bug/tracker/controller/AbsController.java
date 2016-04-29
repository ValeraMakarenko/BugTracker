package com.bug.tracker.controller;

import com.bug.tracker.mapper.ProjectMapper;
import com.bug.tracker.service.*;
import com.bug.tracker.util.BugReportUtils;
import com.bug.tracker.util.ProjectUtils;
import com.bug.tracker.util.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;


public abstract class AbsController {

    @Autowired
    protected StatusService statusService;
    @Autowired
    protected PriorityService priorityService;
    @Autowired
    protected UserService userService;
    @Autowired
    protected BugReportService bugReportService;
    @Autowired
    protected BugReportUtils bugReportUtils;
    @Autowired
    protected UserProfileService userProfileService;
    @Autowired
    protected UserUtils userUtils;
    @Autowired
    protected ProjectService projectService;
    @Autowired
    protected ProjectUtils projectUtils;
    @Autowired
    protected TypeProjectService typeProjectService;
    @Autowired
    protected ProjectMapper projectMapper;

    protected String getPrincipal() {
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
