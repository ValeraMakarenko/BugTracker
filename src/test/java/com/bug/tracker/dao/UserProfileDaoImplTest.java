package com.bug.tracker.dao;
import com.bug.tracker.configuration.HibernateTestConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateTestConfiguration.class)
public class UserProfileDaoImplTest{

    @Autowired
    UserProfileDao userProfileDao;

    @Test
    public void findAllRoles(){
        Assert.assertEquals(userProfileDao.findAll().size(), 0);
    }
}
