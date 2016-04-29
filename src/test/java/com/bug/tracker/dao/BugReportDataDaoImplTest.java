package com.bug.tracker.dao;

import org.junit.Assert;
import org.junit.Test;

public class BugReportDataDaoImplTest extends AbstractDataDaoTest {

    @Test
    public void findAllBugReports() {
        Assert.assertEquals(bugReportDao.findAll().size(), 1);
    }

    @Test
    public void findByIdBugReport() {
        Assert.assertNull(bugReportDao.findById(200));
    }

    @Test
    public void deleteBugReportById() {
        bugReportDao.deleteBugReportById(1);
        Assert.assertEquals(bugReportDao.findAll().size(), 0);
    }

}
