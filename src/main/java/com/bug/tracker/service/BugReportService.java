package com.bug.tracker.service;

import com.bug.tracker.dto.BugReportDto;
import com.bug.tracker.model.BugReportForViewKotlin;
import org.springframework.security.access.annotation.Secured;

import java.util.List;

public interface BugReportService {

    void updateBugReport(BugReportDto bugReportDto);

    List<BugReportForViewKotlin> findAll();

    @Secured("ROLE_Project_Manager")
    void deleteBugReportById(int id);

    BugReportDto findById(int id);

    void save(BugReportDto bugReportDto);
}
