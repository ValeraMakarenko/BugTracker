package com.bug.tracker.service;

import com.bug.tracker.model.BugReport;
import com.bug.tracker.model.Priority;
import com.bug.tracker.model.Status;
import com.bug.tracker.model.User;
import org.springframework.security.access.annotation.Secured;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface BugReportService {

    void updateBugReport(String title, String summary, String stepsToReproduce, String actualResult, String expectedResult, User assignedUser, Set<Status> statuses, Set<Priority> priorities, User reporterUser, int id, LocalDateTime date);

    List<BugReport> findAll();

    @Secured("Project_Manager")
    void deleteBugReportById(int id);

    BugReport findById(int id);

    void save(String title, String summary, String stepsToReproduce, String actualResult, String expectedResult, User assignedUser, Set<Status> statuses, Set<Priority> priorities, User reporterUser);
}
