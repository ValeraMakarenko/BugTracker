package com.bug.tracker.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class BugReportDto implements Serializable {

    private int id;
    private String title;
    private String summary;
    private String stepsToReproduce;
    private String actualResult;
    private String expectedResult;
    private int reporterId;
    private int assignedId;
    private int statusId;
    private int priorityId;
    private int projectId;
    private LocalDateTime date;

    public BugReportDto() {
    }

    public BugReportDto(int id, String title, String summary, String stepsToReproduce, String actualResult, String expectedResult, int reporterId, int assignedId, int statusId, int priorityId, int projectId, LocalDateTime date) {
        this.id = id;
        this.title = title;
        this.summary = summary;
        this.stepsToReproduce = stepsToReproduce;
        this.actualResult = actualResult;
        this.expectedResult = expectedResult;
        this.reporterId = reporterId;
        this.assignedId = assignedId;
        this.statusId = statusId;
        this.priorityId = priorityId;
        this.projectId = projectId;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getStepsToReproduce() {
        return stepsToReproduce;
    }

    public void setStepsToReproduce(String stepsToReproduce) {
        this.stepsToReproduce = stepsToReproduce;
    }

    public String getActualResult() {
        return actualResult;
    }

    public void setActualResult(String actualResult) {
        this.actualResult = actualResult;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    public void setExpectedResult(String expectedResult) {
        this.expectedResult = expectedResult;
    }

    public int getReporterId() {
        return reporterId;
    }

    public void setReporterId(int reporterId) {
        this.reporterId = reporterId;
    }

    public int getAssignedId() {
        return assignedId;
    }

    public void setAssignedId(int assignedId) {
        this.assignedId = assignedId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public int getPriorityId() {
        return priorityId;
    }

    public void setPriorityId(int priorityId) {
        this.priorityId = priorityId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
