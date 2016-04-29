package com.bug.tracker.dao;

import com.bug.tracker.configuration.HibernateTestConfiguration;
import com.bug.tracker.model.*;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.Month;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateTestConfiguration.class)
@Transactional
public abstract class AbstractDataDaoTest {

    @Autowired
    protected UserProfileDao userProfileDao;
    @Autowired
    protected TypeProjectDao typeProjectDao;
    @Autowired
    protected UserDao userDao;
    @Autowired
    protected ProjectDao projectDao;
    @Autowired
    protected StatusDao statusDao;
    @Autowired
    protected PriorityDao priorityDao;
    @Autowired
    protected BugReportDao bugReportDao;



    @Before
    public void saveDataToDb() {
        UserProfile userProfile = getUserProfile();
        userProfileDao.save(userProfile);
        User user = getUser(userProfile);
        userDao.save(user);

        TypeProject typeProject = getTypeProject();
        typeProjectDao.save(typeProject);

        Project project = getProject(user, typeProject);
        projectDao.save(project);

        Status status = getStatus();
        statusDao.save(status);

        Priority priority = getPriority();
        priorityDao.save(priority);

        BugReport bugReport = getBugReport(user, user, status, project, priority);
        bugReportDao.save(bugReport);
    }

    private UserProfile getUserProfile() {
        UserProfile userProfile = new UserProfile();
        userProfile.setRole("Developer");
        return userProfile;
    }

    private User getUser(UserProfile userProfile) {
        User user = new User();
        user.setFirstName("Mike");
        user.setLastName("Magic");
        user.setLogin("Mike");
        user.setPassword("fff111");
        user.setEmail("asd@mail.ru");
        user.setUserProfile(userProfile);

        return user;
    }

    private TypeProject getTypeProject() {
        TypeProject typeProject = new TypeProject();
        typeProject.setType("Software");
        return typeProject;
    }

    private Project getProject(User user, TypeProject typeProject) {
        Project project = new Project();
        project.setNameProject("project");
        project.setUrl("https://translate.google.com");
        project.setManager(user);
        project.setTypeProject(typeProject);
        return project;
    }

    private Status getStatus() {
        Status status = new Status();
        status.setType("Open");
        return status;
    }

    private Priority getPriority() {
        Priority priority = new Priority();
        priority.setType("Minor");
        return priority;
    }

    private BugReport getBugReport(User reporter, User assigned, Status status,Project project, Priority priority) {
        BugReport bugReport = new BugReport();
        bugReport.setTitle("title");
        bugReport.setSummary("summary");
        bugReport.setStepsToReproduce("steps");
        bugReport.setActualResult("actual");
        bugReport.setExpectedResult("expected");
        bugReport.setReporter(reporter);
        bugReport.setAssigned(assigned);
        bugReport.setStatus(status);
        bugReport.setProject(project);
        bugReport.setPriority(priority);
        bugReport.setStartBugReport(LocalDateTime.of(2016, Month.APRIL, 10, 20, 30));
        return bugReport;
    }
}
