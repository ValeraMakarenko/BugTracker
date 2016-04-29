package com.bug.tracker.dao;

import org.junit.Assert;
import org.junit.Test;

public class PriorityDataDaoImplTest extends AbstractDataDaoTest {

    @Test
    public void findAllStatuses(){
        Assert.assertEquals(priorityDao.findAll().size(), 1);
    }

    @Test
    public void findByTypeStatus(){
        Assert.assertNotNull(priorityDao.findByType("Minor"));
        Assert.assertNull(priorityDao.findByType("NoExist"));
    }

    @Test
    public void findByIdStatus(){
        Assert.assertNull(priorityDao.findById(200));
    }
}
