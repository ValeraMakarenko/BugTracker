package com.bug.tracker.mapper;

import com.bug.tracker.dto.BugReportDto;
import com.bug.tracker.model.BugReport;
import com.bug.tracker.model.BugReportForViewKotlin;

import java.util.List;

public interface BugReportMapper {

    BugReportDto bugReportToBugReportDto(BugReport bugReport);

    BugReport bugReportDtoToBugReport(BugReportDto bugReportDto);

    List<BugReport> bugReportDtosToBugReports (List<BugReportDto> bugReportDtoList);

    List<BugReportDto> bugReportsToBugReportDtos(List<BugReport> bugReportList);

    BugReportForViewKotlin BugReportToBugReportForViewKotlin(BugReport bugReport);

    List<BugReportForViewKotlin> BugReportsToBugReportForViewKotlins(List<BugReport> bugReportList);
}
