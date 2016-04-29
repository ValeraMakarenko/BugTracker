package com.bug.tracker.dao;

import org.junit.Assert;
import org.junit.Test;

public class TypeProjectDataDaoImplTest extends AbstractDataDaoTest {

    @Test
    public void findAllTypeProjects(){
        Assert.assertEquals(typeProjectDao.findAll().size(), 1);
    }

    @Test
    public void findByTypeTypeProject(){
        Assert.assertNotNull(typeProjectDao.findByType("Software"));
        Assert.assertNull(typeProjectDao.findByType("NoExist"));
    }

    @Test
    public void findByIdTypeProject() throws Exception {
        Assert.assertNull(typeProjectDao.findById(200));
    }

}
