package com.bug.tracker.controller;

import com.bug.tracker.dao.BugReportDao;
import com.bug.tracker.model.BugReportForViewKotlin;
import com.bug.tracker.model.User;
import com.bug.tracker.service.BugReportService;
import com.bug.tracker.service.UserService;
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
import java.util.List;

import static org.mockito.Mockito.*;

public class BugReportControllerTest {
    @Mock
    private BugReportDao bugReportDao;

    @Mock
    private BugReportService bugReportService;

    @Mock
    private UserService userService;

    @InjectMocks
    private BugReportController bugReportController;

    @Spy
    private List<BugReportForViewKotlin> bugReportForViewKotlinList = new ArrayList<>();

    @Spy
    private ModelMap model;

    @Spy
    private User user;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        bugReportForViewKotlinList = getBugReportList();
    }


    @Test
    public void bugReportList(){
        when(bugReportService.findAll()).thenReturn(bugReportForViewKotlinList);
        Assert.assertEquals(bugReportController.bugReportList(model), "bugreportlist");
        Assert.assertEquals(model.get("bugReports"), bugReportForViewKotlinList);
        verify(bugReportService, atLeastOnce()).findAll();
    }



    private List<BugReportForViewKotlin> getBugReportList(){
        BugReportForViewKotlin bugReportForViewKotlin = new BugReportForViewKotlin();

        bugReportForViewKotlin.setId(1);
        bugReportForViewKotlin.setTitle("title");
        bugReportForViewKotlin.setSummary("summary");
        bugReportForViewKotlin.setStepsToReproduce("steps");
        bugReportForViewKotlin.setActualResult("actual");
        bugReportForViewKotlin.setExpectedResult("expected");
        bugReportForViewKotlin.setReporter("sss");
        bugReportForViewKotlin.setAssigned("ddd");
        bugReportForViewKotlin.setStatus("open");
        bugReportForViewKotlin.setPriority("block");
        bugReportForViewKotlin.setDate(LocalDateTime.of(2016, Month.APRIL, 10, 20, 30));

        List<BugReportForViewKotlin> bugReportForViewKotlinList =new ArrayList<>();
        bugReportForViewKotlinList.add(bugReportForViewKotlin);
        return  bugReportForViewKotlinList;
    }

    private String getPrincipal() {
        return "login";
    }

   /* private User getUser() {
        User user = new User();
        user.setId(1);
        user.setLogin("login");
        user.setPassword("213");
        user.setFirstName("ddd");
        user.setLastName("ccc");
        user.setEmail("as@as");
        user.setUserProfile(getUserProfile());
        return user;
    }

    private UserProfile getUserProfile() {
        UserProfile userProfile = new UserProfile();
        userProfile.setId(1);
        userProfile.setRole("role");
        return userProfile;
    }*/


}

