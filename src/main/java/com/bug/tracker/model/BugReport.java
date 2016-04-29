package com.bug.tracker.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "BUG_REPORT")
public class BugReport extends AbstractEntity {

    @NotEmpty
    @Column(name = "TITLE", nullable = false)
    private String title;

    @NotEmpty
    @Column(name = "SUMMARY", nullable = false)
    private String summary;

    @NotEmpty
    @Column(name = "STEPS_TO_REPRODUCE", nullable = false)
    private String stepsToReproduce;

    @NotEmpty
    @Column(name = "ACTUAL_RESULT", nullable = false)
    private String actualResult;

    @NotEmpty
    @Column(name = "EXPECTED_RESULT", nullable = false)
    private String expectedResult;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_REPORTER_ID", referencedColumnName="ID", nullable = false)
    private User reporter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_ASSIGNED_ID", referencedColumnName="ID", nullable = false)
    private User assigned;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_STATUS_ID", referencedColumnName="ID", nullable = false)
    private Status status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PROJECT_ID", referencedColumnName="ID", nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FK_PRIORITY_ID", referencedColumnName="ID", nullable = false)
    private Priority priority;

    @Column(name = "START_BUG_REPORT", nullable = false)
    private LocalDateTime startBugReport;

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

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public User getAssigned() {
        return assigned;
    }

    public void setAssigned(User assigned) {
        this.assigned = assigned;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDateTime getStartBugReport() {
        return startBugReport;
    }

    public void setStartBugReport(LocalDateTime startBugReport) {
        this.startBugReport = startBugReport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        BugReport bugReport = (BugReport) o;

        if (!title.equals(bugReport.title)) return false;
        if (!summary.equals(bugReport.summary)) return false;
        if (!stepsToReproduce.equals(bugReport.stepsToReproduce)) return false;
        if (!actualResult.equals(bugReport.actualResult)) return false;
        if (!expectedResult.equals(bugReport.expectedResult)) return false;
        if (!reporter.equals(bugReport.reporter)) return false;
        if (!assigned.equals(bugReport.assigned)) return false;
        if (!status.equals(bugReport.status)) return false;
        if (!project.equals(bugReport.project)) return false;
        if (!priority.equals(bugReport.priority)) return false;
        return startBugReport.equals(bugReport.startBugReport);

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + title.hashCode();
        result = 31 * result + summary.hashCode();
        result = 31 * result + stepsToReproduce.hashCode();
        result = 31 * result + actualResult.hashCode();
        result = 31 * result + expectedResult.hashCode();
        result = 31 * result + reporter.hashCode();
        result = 31 * result + assigned.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + project.hashCode();
        result = 31 * result + priority.hashCode();
        result = 31 * result + startBugReport.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "BugReport{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", stepsToReproduce='" + stepsToReproduce + '\'' +
                ", actualResult='" + actualResult + '\'' +
                ", expectedResult='" + expectedResult + '\'' +
                ", reporter=" + reporter +
                ", assigned=" + assigned +
                ", status=" + status +
                ", project=" + project +
                ", priority=" + priority +
                ", startBugReport=" + startBugReport +
                '}';
    }
}
