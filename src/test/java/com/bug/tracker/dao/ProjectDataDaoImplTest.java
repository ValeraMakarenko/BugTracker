package com.bug.tracker.dao;

import org.junit.Assert;
import org.junit.Test;

public class ProjectDataDaoImplTest extends AbstractDataDaoTest {


    @Test
    public void findAllProjects() {
        Assert.assertEquals(projectDao.findAll().size(), 1);
    }

    @Test
    public void findByIdProject() {
        Assert.assertNull(projectDao.findById(200));
    }

}
