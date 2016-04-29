package com.bug.tracker.dao;

import org.junit.Assert;
import org.junit.Test;

public class UserDataDaoImplTest extends AbstractDataDaoTest {

    @Test
    public void findAllUser() {
        Assert.assertEquals(userDao.findAll().size(), 1);
    }

    @Test
    public void findByIdUser() {
        Assert.assertNull(userDao.findById(200));
    }

    @Test
    public void findByLoginUser() {
        Assert.assertNotNull(userDao.findByLogin("Mike"));
        Assert.assertNull(userDao.findByLogin("Derek"));
    }

}
