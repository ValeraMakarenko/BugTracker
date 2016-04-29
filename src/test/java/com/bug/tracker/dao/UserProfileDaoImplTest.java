package com.bug.tracker.dao;
import com.bug.tracker.configuration.HibernateTestConfiguration;
import com.bug.tracker.model.UserProfile;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateTestConfiguration.class)
@Transactional
public class UserProfileDaoImplTest{

    @Autowired
    private UserProfileDao userProfileDao;

    @Before
    public void saveUserProfile() {
        UserProfile userProfile = new UserProfile();
        userProfile.setRole("Developer");
        userProfileDao.save(userProfile);
    }

    @Test
    public void findAllUserProfiles(){
        Assert.assertEquals(userProfileDao.findAll().size(), 1);
    }

    @Test
    public void findByRoleUserProfile(){
        Assert.assertNotNull(userProfileDao.findByRole("Developer"));
        Assert.assertNull(userProfileDao.findByRole("NoExist"));
    }

    @Test
    public void findByIdUserProfile(){
        Assert.assertNull(userProfileDao.findById(200));
    }
}
