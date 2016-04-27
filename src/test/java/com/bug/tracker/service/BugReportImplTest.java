/*
package com.bug.tracker.service;

import com.bug.tracker.dao.BugReportDao;
import com.bug.tracker.model.*;
import com.bug.tracker.service.impl.BugReportServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class BugReportImplTest {
    @Mock
    BugReportDao bugReportDao;

    @InjectMocks
    BugReportServiceImpl bugReportService;

    @Spy
    List<BugReport> bugReports = new ArrayList<>();

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        bugReports = getBugReportList();
    }

    @Test
    public void findById(){
        BugReport bug = bugReports.get(0);
        when(bugReportDao.findById(anyInt())).thenReturn(bug);
        Assert.assertEquals(bugReportService.findById(bug.getId()),bug);
    }

    @Test
    public void deleteBugReport(){
        doNothing().when(bugReportDao).deleteBugReportById(anyInt());
        bugReportService.deleteBugReportById(anyInt());
        verify(bugReportDao, atLeastOnce()).deleteBugReportById(anyInt());
    }

    @Test
    public void findAllBugReports(){
        when(bugReportDao.findAll()).thenReturn(bugReports);
        Assert.assertEquals(bugReportService.findAll(), bugReports);
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
*/
