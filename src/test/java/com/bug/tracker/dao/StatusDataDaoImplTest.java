package com.bug.tracker.dao;

import org.junit.Assert;
import org.junit.Test;

public class StatusDataDaoImplTest extends AbstractDataDaoTest {

    @Test
    public void findAllStatuses(){
        Assert.assertEquals(statusDao.findAll().size(), 1);
    }

    @Test
    public void findByTypeStatus(){
        Assert.assertNotNull(statusDao.findByType("Open"));
        Assert.assertNull(statusDao.findByType("NoExist"));
    }

    @Test
    public void findByIdStatus(){
        Assert.assertNull(statusDao.findById(200));
    }

}
