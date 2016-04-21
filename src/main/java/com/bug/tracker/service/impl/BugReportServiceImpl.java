package com.bug.tracker.service.impl;

import com.bug.tracker.dao.BugReportDao;
import com.bug.tracker.model.BugReport;
import com.bug.tracker.model.Priority;
import com.bug.tracker.model.Status;
import com.bug.tracker.model.User;
import com.bug.tracker.service.BugReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Service("bugReportService")
@Transactional
public class BugReportServiceImpl implements BugReportService {

    @Autowired
    private BugReportDao dao;

    @Override
    public void updateBugReport(String title, String summary, String stepsToReproduce, String actualResult, String expectedResult, User assignedUser, Set<Status> statuses, Set<Priority> priorities, User reporterUser, int id, LocalDateTime date) {
        BugReport bugReport = dao.findById(id);
        if (bugReport != null) {
            bugReport.setTitle(title);
            bugReport.setSummary(summary);
            bugReport.setStepsToReproduce(stepsToReproduce);
            bugReport.setActualResult(actualResult);
            bugReport.setExpectedResult(expectedResult);
            bugReport.setAssignedId(assignedUser);
            bugReport.setStatuses(statuses);
            bugReport.setPriorities(priorities);
            bugReport.setReporterId(reporterUser);
            bugReport.setDate(date);
        }
    }

    @Override
    public List<BugReport> findAll() {
        return dao.findAll();
    }

    @Override
    public void deleteBugReportById(int id) {
        dao.deleteBugReportById(id);
    }

    public BugReport findById(int id) {
        return dao.findById(id);
    }

    @Override
    public void save(String title, String summary, String stepsToReproduce, String actualResult, String expectedResult, User assignedUser, Set<Status> statuses, Set<Priority> priorities, User reporterUser) {
        BugReport bugReport = new BugReport();
        bugReport.setTitle(title);
        bugReport.setSummary(summary);
        bugReport.setStepsToReproduce(stepsToReproduce);
        bugReport.setActualResult(actualResult);
        bugReport.setExpectedResult(expectedResult);
        bugReport.setAssignedId(assignedUser);
        bugReport.setStatuses(statuses);
        bugReport.setPriorities(priorities);
        bugReport.setReporterId(reporterUser);
        bugReport.setDate(LocalDateTime.now());

        dao.save(bugReport);
    }

}