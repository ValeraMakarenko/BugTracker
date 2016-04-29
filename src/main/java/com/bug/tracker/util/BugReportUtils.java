package com.bug.tracker.util;

import com.bug.tracker.dto.BugReportDto;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class BugReportUtils implements Validator {
    public boolean supports(Class<?> clazz) {
        return BugReportDto.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        BugReportDto bugReportDto = (BugReportDto) target;
        bugReportDto.setTitle(bugReportDto.getTitle().trim());
        bugReportDto.setSummary(bugReportDto.getSummary().trim());
        bugReportDto.setStepsToReproduce(bugReportDto.getStepsToReproduce().trim());
        bugReportDto.setActualResult(bugReportDto.getActualResult().trim());
        bugReportDto.setExpectedResult(bugReportDto.getExpectedResult().trim());
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.empty");
        String title = bugReportDto.getTitle();
        if ((title.length()) > 20) {
            errors.rejectValue("title", "title.tooLong");
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "summary", "summary.empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "stepsToReproduce", "stepsToReproduce.empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "actualResult", "actualResult.empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "expectedResult", "expectedResult.empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "reporterId", "reporterId.empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "assignedId", "assignedId.empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "statusId", "statusId.empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "priorityId", "priorityId.empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "projectId", "projectId.empty");

    }
}

