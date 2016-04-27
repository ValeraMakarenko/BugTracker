package com.bug.tracker.mapper.Impl;

import com.bug.tracker.dto.BugReportDto;
import com.bug.tracker.mapper.BugReportMapper;
import com.bug.tracker.model.*;
import com.bug.tracker.service.BugReportService;
import com.bug.tracker.service.PriorityService;
import com.bug.tracker.service.StatusService;
import com.bug.tracker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BugReportMapperImpl implements BugReportMapper {

    @Autowired
    private UserService userService;
    @Autowired
    private PriorityService priorityService;
    @Autowired
    private StatusService statusService;
    @Autowired
    private BugReportService bugReportService;

    @Override
    public BugReportDto bugReportToBugReportDto(BugReport bugReport) {
        BugReportDto bugReportDto = new BugReportDto();
        bugReportDto.setId(bugReport.getId());
        bugReportDto.setTitle(bugReport.getTitle());
        bugReportDto.setSummary(bugReport.getSummary());
        bugReportDto.setStepsToReproduce(bugReport.getStepsToReproduce());
        bugReportDto.setActualResult(bugReport.getActualResult());
        bugReportDto.setExpectedResult(bugReport.getExpectedResult());
        bugReportDto.setReporterId(getUserId(bugReport.getReporter()));
        bugReportDto.setAssignedId(getUserId(bugReport.getAssigned()));
        bugReportDto.setStatusId(getStatusId(bugReport.getStatus()));
        bugReportDto.setPriorityId(getPriorityId(bugReport.getPriority()));
        bugReportDto.setDate(bugReport.getStartBugReport());

        return bugReportDto;
    }

    @Override
    public BugReport bugReportDtoToBugReport(BugReportDto bugReportDto) {
        BugReport bugReport = new BugReport();
        //bugReport.setId(bugReportDto.getId());
        bugReport.setTitle(bugReportDto.getTitle());
        bugReport.setSummary(bugReportDto.getSummary());
        bugReport.setStepsToReproduce(bugReportDto.getStepsToReproduce());
        bugReport.setActualResult(bugReportDto.getActualResult());
        bugReport.setExpectedResult(bugReportDto.getExpectedResult());
        bugReport.setReporter(getUserById(bugReportDto.getReporterId()));
        bugReport.setAssigned(getUserById(bugReportDto.getAssignedId()));
        bugReport.setStatus(getStatusById(bugReportDto.getStatusId()));
        bugReport.setPriority(getPriorityById(bugReportDto.getPriorityId()));
        bugReport.setStartBugReport(bugReportDto.getDate());
        return bugReport;
    }

    @Override
    public List<BugReport> bugReportDtosToBugReports(List<BugReportDto> bugReportDtoList) {
        //List<BugReport> bugReports = bugReportService.findAll();
        return null;
    }

    @Override
    public List<BugReportDto> bugReportsToBugReportDtos(List<BugReport> bugReportList) {
        if (bugReportList == null) {
            return null;
        }
        List<BugReportDto> bugReportDtos = new ArrayList<>();
        for (BugReport bugReport : bugReportList) {
            bugReportDtos.add(bugReportToBugReportDto(bugReport));
        }
        return bugReportDtos;
    }

    @Override
    public BugReportForViewKotlin BugReportToBugReportForViewKotlin(BugReport bugReport) {
        BugReportForViewKotlin bugReportForViewKotlin = new BugReportForViewKotlin();
        bugReportForViewKotlin.setId(bugReport.getId());
        bugReportForViewKotlin.setTitle(bugReport.getTitle());
        bugReportForViewKotlin.setSummary(bugReport.getSummary());
        bugReportForViewKotlin.setStepsToReproduce(bugReport.getStepsToReproduce());
        bugReportForViewKotlin.setActualResult(bugReport.getActualResult());
        bugReportForViewKotlin.setExpectedResult(bugReport.getExpectedResult());
        bugReportForViewKotlin.setReporter(bugReport.getReporter().getLogin());
        bugReportForViewKotlin.setAssigned(bugReport.getAssigned().getLogin());
        bugReportForViewKotlin.setStatus(bugReport.getStatus().getType());
        bugReportForViewKotlin.setPriority(bugReport.getPriority().getType());
        bugReportForViewKotlin.setDate(bugReport.getStartBugReport());
        return bugReportForViewKotlin;
    }

    @Override
    public List<BugReportForViewKotlin> BugReportsToBugReportForViewKotlins(List<BugReport> bugReportList) {
        List<BugReportForViewKotlin> bugReportForViewKotlinList = new ArrayList<>();
        for (BugReport bugReport : bugReportList) {
            bugReportForViewKotlinList.add(BugReportToBugReportForViewKotlin(bugReport));
        }
        return bugReportForViewKotlinList;
    }

    private User getUserById(int id) {
        return userService.findById(id);
    }

    private Status getStatusById(int id) {
        return statusService.findById(id);
    }

    private Priority getPriorityById(int id) {
        return priorityService.findById(id);
    }

    private int getUserId(User user) {
        return user.getId();
    }

    private int getStatusId(Status status) {
        return status.getId();
    }

    private int getPriorityId(Priority priority) {
        return priority.getId();
    }
}
