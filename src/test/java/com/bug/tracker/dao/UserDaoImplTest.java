/*
package com.bug.tracker.dao;

import com.bug.tracker.configuration.HibernateTestConfiguration;
import com.bug.tracker.model.User;
import com.bug.tracker.model.UserProfile;
import com.bug.tracker.service.UserProfileService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateTestConfiguration.class)
@Transactional
public class UserDaoImplTest{

    @Autowired
    private UserDao userDao;
    @Mock
    private UserProfileService userProfileService;
    @Spy
    private User user;


    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        user = getUser();
    }

  	@Test
    public void saveUser(){
        userDao.save(user);
        Assert.assertEquals(userDao.findAll().size(), 1);
    }

    private User getUser() {
        User user = new User();
        //user.setId(1);
        user.setLogin("login");
        user.setPassword("213");
        user.setFirstName("ddd");
        user.setLastName("ccc");
        user.setEmail("as@as");
        UserProfile userProfile = userProfileService.findById(2);
        user.setUserProfile(userProfile);
        //user.setUserProfile(getUserProfile());
        return user;
    }

    private UserProfile getUserProfile() {
        UserProfile userProfile = new UserProfile();
        userProfile.setId(2);
        userProfile.setRole("Developer");
        return userProfile;
    }
}
*/
