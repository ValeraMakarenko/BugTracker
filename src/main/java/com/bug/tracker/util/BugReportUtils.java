package com.bug.tracker.util;

import com.bug.tracker.dto.BugReportDto;

public class BugReportUtils {

    private BugReportUtils() {
        throw new AssertionError("Class contains static methods only. You should not instantiate it!");
    }

    public static boolean validateBugReport(BugReportDto bugReportDto) {
        String title = bugReportDto.getTitle();
        String summary = bugReportDto.getSummary();
        String stepsToReproduce = bugReportDto.getStepsToReproduce();
        String actualResult = bugReportDto.getActualResult();
        String expectedResult = bugReportDto.getExpectedResult();

        return !(title.isEmpty() || summary.isEmpty() || stepsToReproduce.isEmpty()
                || actualResult.isEmpty() || expectedResult.isEmpty());

    }
}
