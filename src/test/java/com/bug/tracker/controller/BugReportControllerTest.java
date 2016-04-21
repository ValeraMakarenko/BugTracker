package com.bug.tracker.controller;

import com.bug.tracker.dao.BugReportDao;
import com.bug.tracker.model.*;
import com.bug.tracker.service.BugReportService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.ui.ModelMap;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BugReportControllerTest {
    @Mock
    BugReportDao bugReportDao;

    @Mock
    BugReportService bugReportService;

    @InjectMocks
    BugReportController bugReportController;

    @Spy
    List<BugReport> bugReports = new ArrayList<>();

    @Spy
    ModelMap model;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        bugReports = getBugReportList();
    }

    @Test
    public void newBugReport(){
        Assert.assertEquals(bugReportController.newBugReport(model), "newbugreport");
        Assert.assertNotNull(model.get("bugReport"));
        Assert.assertEquals(((BugReport)model.get("bugReport")).getId(), 0);
    }

    public List<BugReport> getBugReportList(){
        BugReport bugReport = new BugReport();

        bugReport.setId(1);
        bugReport.setTitle("Title");
        bugReport.setSummary("Summary");
        bugReport.setStepsToReproduce("Steps");
        bugReport.setActualResult("Actual");
        bugReport.setExpectedResult("Expected");
        bugReport.setReporterId(getReporter());
        bugReport.setAssignedId(getReporter());
        bugReport.setStatuses(getStatus());
        bugReport.setPriorities(getPriority());
        bugReport.setDate(LocalDateTime.of(2016, Month.APRIL, 10, 20, 30));

        List<BugReport> bugReports =new ArrayList<>();
        bugReports.add(bugReport);
        return  bugReports;
    }

    public User getReporter(){
        User reporter = new User();
        reporter.setId(1);
        reporter.setLogin("Login");
        reporter.setPassword("pass");
        reporter.setFirstName("Name");
        reporter.setLastName("LastName");
        reporter.setEmail("email@dot.com");
        reporter.setUserProfiles(getUserProfile());
        return reporter;
    }

    public Set<UserProfile> getUserProfile(){
        UserProfile userProfile = new UserProfile();
        userProfile.setId(1);
        userProfile.setRole("Tester");
        Set<UserProfile> userProfileSet = new HashSet<>();
        userProfileSet.add(userProfile);
        return userProfileSet;
    }

    public Set<Status> getStatus(){
        Status status = new Status();
        status.setId(1);
        status.setType("Open");
        Set<Status> statuses = new HashSet<>();
        statuses.add(status);
        return statuses;
    }

    public Set<Priority> getPriority(){
        Priority priority = new Priority();
        priority.setId(1);
        priority.setType("Minor");
        Set<Priority> priorities = new HashSet<>();
        priorities.add(priority);
        return priorities;
    }

}

