package com.bug.tracker.model;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
@Entity
@Table(name = "BUG_REPORT")
public class BugReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

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

    @ManyToOne
    @JoinColumn(name = "FK_REPORTER_ID", referencedColumnName="ID", nullable = false)
    private User reporterId;

    @ManyToOne
    @JoinColumn(name = "FK_ASSIGNED_ID", referencedColumnName="ID", nullable = false)
    private User assignedId;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "BUG_REPORT_STATUS",
            joinColumns = {@JoinColumn(name = "FK_BUG_REPORT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "FK_STATUS_ID")})
    private Set<Status> statuses = new HashSet<Status>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "BUG_REPORT_PRIORITY",
            joinColumns = {@JoinColumn(name = "FK_BUG_REPORT_ID")},
            inverseJoinColumns = {@JoinColumn(name = "FK_PRIORITY_ID")})
    private Set<Priority> priorities = new HashSet<Priority>();

    //@NotEmpty
    //@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    @Column(name = "START_BUG_REPORT", nullable = false)
    //@Type(type = "org.hibernate.type.LocalDateTimeType")
    //@Convert(disableConversion = true)
    //@Convert(converter = LocalDateTimeConverter.class)
    private LocalDateTime date;

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

    public User getReporterId() {
        return reporterId;
    }

    public void setReporterId(User reporterId) {
        this.reporterId = reporterId;
    }

    public User getAssignedId() {
        return assignedId;
    }

    public void setAssignedId(User assignedId) {
        this.assignedId = assignedId;
    }

    public Set<Status> getStatuses() {
        return statuses;
    }

    public void setStatuses(Set<Status> statuses) {
        this.statuses = statuses;
    }

    public Set<Priority> getPriorities() {
        return priorities;
    }

    public void setPriorities(Set<Priority> priorities) {
        this.priorities = priorities;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BugReport bugReport = (BugReport) o;

        if (id != bugReport.id) return false;
        return title.equals(bugReport.title);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + title.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "BugReport{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", stepsToReproduce='" + stepsToReproduce + '\'' +
                ", actualResult='" + actualResult + '\'' +
                ", expectedResult='" + expectedResult + '\'' +
                ", reporterId=" + reporterId +
                ", assignedId=" + assignedId +
                ", statuses=" + statuses +
                ", priorities=" + priorities +
                ", date=" + date +
                '}';
    }

}
