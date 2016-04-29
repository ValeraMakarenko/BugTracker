package com.bug.tracker.service;

import com.bug.tracker.dao.*;
import com.bug.tracker.dto.BugReportDto;
import com.bug.tracker.mapper.BugReportMapper;
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
import java.util.List;

import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.*;

public class BugReportServiceImplTest {

    @Mock
    private BugReportDao bugReportDao;
    @Mock
    private StatusDao statusDao;
    @Mock
    private PriorityDao priorityDao;
    @Mock
    private UserDao userDao;
    @Mock
    private UserProfileDao userProfileDao;
    @Mock
    private BugReportMapper bugReportMapper;

    @InjectMocks
    private BugReportServiceImpl bugReportService;


    @Spy
    private List<BugReport> bugReports = new ArrayList<>();
    @Spy
    private List<BugReportForViewKotlin> bugReportForViewKotlins = new ArrayList<>();
    @Spy
    private List<BugReportDto> bugReportDtos = new ArrayList<>();

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        bugReports = getBugReportList();
        bugReportForViewKotlins = getBugReportForViewKotlinList();
        bugReportDtos = getBugReportDtoList();
    }

    @Test
    public void findById(){
        BugReportDto bug = bugReportDtos.get(0);
        when(bugReportService.findById(anyInt())).thenReturn(bug);
        Assert.assertEquals(bug, bugReportService.findById(bug.getId()));
    }

    @Test
    public void findAllBugReports(){
        when(bugReportService.findAll()).thenReturn(bugReportForViewKotlins);
        Assert.assertEquals(bugReportForViewKotlins, bugReportService.findAll());
        verify(bugReportMapper).BugReportsToBugReportForViewKotlins(bugReportDao.findAll());
    }

    @Test
    public void deleteBugReport(){
        doNothing().when(bugReportDao).deleteBugReportById(anyInt());
        bugReportService.deleteBugReportById(anyInt());
        verify(bugReportDao, atLeastOnce()).deleteBugReportById(anyInt());
    }

 /*@Test
    public void saveBugReport(){
        doNothing().when(bugReportDao).save(any(BugReport.class));
        bugReportService.save(any(BugReportDto.class));
        verify(bugReportMapper).bugReportDtoToBugReport(any(BugReportDto.class));
   //     verify(any(BugReport.class)).setStartBugReport(any(LocalDateTime.class));
        verify(bugReportDao, atLeastOnce()).save(any(BugReport.class));
    }*/


    private List<BugReport> getBugReportList(){
        BugReport bugReport = new BugReport();

        bugReport.setId(1);
        bugReport.setTitle("Title");
        bugReport.setSummary("Summary");
        bugReport.setStepsToReproduce("Steps");
        bugReport.setActualResult("Actual");
        bugReport.setExpectedResult("Expected");
        bugReport.setReporter(getReporter());
        bugReport.setAssigned(getReporter());
        bugReport.setStatus(getStatus());
        bugReport.setProject(getProject());
        bugReport.setPriority(getPriority());
        bugReport.setStartBugReport(LocalDateTime.of(2016, Month.APRIL, 10, 20, 30));

        List<BugReport> bugReports =new ArrayList<>();
        bugReports.add(bugReport);
        return  bugReports;
    }

    private List<BugReportForViewKotlin> getBugReportForViewKotlinList() {
        BugReportForViewKotlin bugReportForViewKotlin = new BugReportForViewKotlin();

        bugReportForViewKotlin.setId(1);
        bugReportForViewKotlin.setTitle("Title");
        bugReportForViewKotlin.setSummary("Summary");
        bugReportForViewKotlin.setStepsToReproduce("Steps");
        bugReportForViewKotlin.setActualResult("Actual");
        bugReportForViewKotlin.setExpectedResult("Expected");
        bugReportForViewKotlin.setReporter("Mike");
        bugReportForViewKotlin.setAssigned("Mike");
        bugReportForViewKotlin.setStatus("Open");
        bugReportForViewKotlin.setProject("project");
        bugReportForViewKotlin.setPriority("Blocker");
        bugReportForViewKotlin.setDate(LocalDateTime.of(2016, Month.APRIL, 10, 20, 30));

        List<BugReportForViewKotlin> bugReportForViewKotlins = new ArrayList<>();
        bugReportForViewKotlins.add(bugReportForViewKotlin);
        return bugReportForViewKotlins;
    }

    private List<BugReportDto> getBugReportDtoList() {
        BugReportDto bugReportDto = new BugReportDto();

        bugReportDto.setId(1);
        bugReportDto.setTitle("Title");
        bugReportDto.setSummary("Summary");
        bugReportDto.setStepsToReproduce("Steps");
        bugReportDto.setActualResult("Actual");
        bugReportDto.setExpectedResult("Expected");
        bugReportDto.setReporterId(1);
        bugReportDto.setAssignedId(1);
        bugReportDto.setStatusId(1);
        bugReportDto.setProjectId(1);
        bugReportDto.setPriorityId(1);
        bugReportDto.setDate(LocalDateTime.of(2016, Month.APRIL, 10, 20, 30));

        List<BugReportDto> bugReportDtoList = new ArrayList<>();
        bugReportDtoList.add(bugReportDto);
        return bugReportDtoList;
    }

    private TypeProject getTypeProject() {
        TypeProject typeProject = new TypeProject();
        typeProject.setId(1);
        typeProject.setType("Software");
        return typeProject;
    }

    private Project getProject() {
        Project project = new Project();
        project.setId(1);
        project.setNameProject("project");
        project.setUrl("https://translate.google.com");
        project.setManager(getReporter());
        project.setTypeProject(getTypeProject());
        return project;
    }

    private User getReporter(){
        User reporter = new User();
        reporter.setId(1);
        reporter.setLogin("Mike");
        reporter.setPassword("pass");
        reporter.setFirstName("Mike");
        reporter.setLastName("LastName");
        reporter.setEmail("email@dot.com");
        reporter.setUserProfile(getUserProfile());
        return reporter;
    }

    private UserProfile getUserProfile(){
        UserProfile userProfile = new UserProfile();
        userProfile.setId(1);
        userProfile.setRole("Tester");
        return userProfile;
    }

    private Status getStatus(){
        Status status = new Status();
        status.setId(1);
        status.setType("Open");
        return status;
    }

    private Priority getPriority(){
        Priority priority = new Priority();
        priority.setId(1);
        priority.setType("Blocker");
        return priority;
    }

}
