package com.bug.tracker.service.impl;

import com.bug.tracker.dao.BugReportDao;
import com.bug.tracker.dto.BugReportDto;
import com.bug.tracker.mapper.BugReportMapper;
import com.bug.tracker.model.BugReport;
import com.bug.tracker.model.BugReportForViewKotlin;
import com.bug.tracker.service.BugReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service("bugReportService")
@Transactional
public class BugReportServiceImpl implements BugReportService {

    @Autowired
    private BugReportDao dao;
    @Autowired
    private BugReportMapper bugReportMapper;

    @Override
    public void updateBugReport(BugReportDto bugReportDto) {
        BugReport bugReport = bugReportMapper.bugReportDtoToBugReport(bugReportDto);
        BugReport updateBugReport = dao.findById(bugReportDto.getId());
        if (updateBugReport != null) {
            updateBugReport.setTitle(bugReport.getTitle());
            updateBugReport.setSummary(bugReport.getSummary());
            updateBugReport.setStepsToReproduce(bugReport.getStepsToReproduce());
            updateBugReport.setActualResult(bugReport.getActualResult());
            updateBugReport.setExpectedResult(bugReport.getExpectedResult());
            updateBugReport.setAssigned(bugReport.getAssigned());
            updateBugReport.setReporter(bugReport.getReporter());
            updateBugReport.setStatus(bugReport.getStatus());
            updateBugReport.setPriority(bugReport.getPriority());
            updateBugReport.setStartBugReport(bugReport.getStartBugReport());
        }
    }

    @Override
    public List<BugReportForViewKotlin> findAll() {
        return bugReportMapper.BugReportsToBugReportForViewKotlins(dao.findAll());
    }

    @Override
    public void deleteBugReportById(int id) {
        dao.deleteBugReportById(id);
    }

    @Override
    public BugReportDto findById(int id) {
        return bugReportMapper.bugReportToBugReportDto(dao.findById(id));
    }

    @Override
    public void save(BugReportDto bugReportDto) {
        BugReport bugReport = bugReportMapper.bugReportDtoToBugReport(bugReportDto);
        bugReport.setTitle(bugReport.getTitle());
        bugReport.setSummary(bugReport.getSummary());
        bugReport.setStepsToReproduce(bugReport.getStepsToReproduce());
        bugReport.setActualResult(bugReport.getActualResult());
        bugReport.setExpectedResult(bugReport.getExpectedResult());
        bugReport.setAssigned(bugReport.getAssigned());
        bugReport.setStatus(bugReport.getStatus());
        bugReport.setPriority(bugReport.getPriority());
        bugReport.setReporter(bugReport.getReporter());
        bugReport.setStartBugReport(LocalDateTime.now());

        dao.save(bugReport);
    }

}