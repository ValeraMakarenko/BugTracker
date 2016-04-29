package com.bug.tracker.controller;

import com.bug.tracker.controller.bug.DeleteBugReportController;
import com.bug.tracker.controller.bug.ListBugReportsController;
import com.bug.tracker.model.BugReportForViewKotlin;
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
import java.util.List;

import static org.mockito.Mockito.*;

public class BugReportControllerTest {

    @Mock
    private BugReportService bugReportService;

    @InjectMocks
    private ListBugReportsController listBugReportsController;
    @InjectMocks
    private DeleteBugReportController deleteBugReportController;

    @Spy
    private List<BugReportForViewKotlin> bugReportForViewKotlinList = new ArrayList<>();
    @Spy
    private ModelMap model;

    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        bugReportForViewKotlinList = getBugReportList();
    }


   @Test
    public void bugReportList(){
        when(bugReportService.findAll()).thenReturn(bugReportForViewKotlinList);
        Assert.assertEquals(listBugReportsController.bugReportList(model), "bugreportlist");
        Assert.assertEquals(model.get("bugReports"), bugReportForViewKotlinList);
        verify(bugReportService, atLeastOnce()).findAll();
    }

    @Test
    public void deleteBugReport(){
        bugReportService.deleteBugReportById(anyInt());
        verify(bugReportService, atLeastOnce()).deleteBugReportById(anyInt());
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

}

