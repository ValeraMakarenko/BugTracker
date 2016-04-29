package com.bug.tracker.util;

import com.bug.tracker.dto.ProjectDto;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProjectUtils implements Validator {
    public boolean supports(Class<?> clazz) {
        return ProjectDto.class.isAssignableFrom(clazz);
    }

    public void validate(Object target, Errors errors) {
        ProjectDto projectDto = (ProjectDto) target;
        UrlValidator urlValidator = new UrlValidator();
        projectDto.setNameProject(projectDto.getNameProject().trim());
        projectDto.setUrl(projectDto.getUrl().trim());

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nameProject", "nameProject.empty");
        String nameProject = projectDto.getNameProject();
        if ((nameProject.length()) > 30) {
            errors.rejectValue("nameProject", "nameProject.tooLong");
        }

        String url = projectDto.getUrl();
        if (url != null && !url.isEmpty()) {
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "url", "url.empty");
            if ((url.length()) > 50) {
                errors.rejectValue("url", "url.tooLong");
            }
            if (!urlValidator.isValid(url)) {
                errors.rejectValue("url", "url.notValid");
            }
        }

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "managerId", "managerId.empty");

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "typeProjectId", "typeProjectId.empty");

    }
}