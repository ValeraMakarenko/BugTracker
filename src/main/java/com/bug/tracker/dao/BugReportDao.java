package com.bug.tracker.dao;

import com.bug.tracker.model.BugReport;
import com.bug.tracker.model.Project;

import java.util.List;


public interface BugReportDao {

    void save(BugReport bugReport);

    BugReport findById(int id);

    List<BugReport> findAll();

    void deleteBugReportById(int id);

    List<BugReport> findBugReportsForProject(Project project);
}
