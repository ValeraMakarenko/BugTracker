package com.bug.tracker.dao;

import com.bug.tracker.configuration.HibernateTestConfiguration;
import com.bug.tracker.model.User;
import com.bug.tracker.model.UserProfile;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateTestConfiguration.class)
@Transactional
public class UserDaoImplTest{

    @Autowired
    UserDao userDao;

    @Autowired
    UserProfileDao userProfileDao;

    @Test
    public void saveUser(){
        UserProfile userProfile = new UserProfile();
        //userProfile.setId(2);
        userProfile.setRole("Developer");
        userProfileDao.save(userProfile);

        User user = new User();
        user.setFirstName("Mike");
        user.setLastName("Magic");
        user.setLogin("Mike");
        user.setPassword("fff111");
        user.setEmail("asd@mail.ru");
        user.setUserProfile(userProfile);
        userDao.save(user);
        Assert.assertEquals(userDao.findAll().size(), 1);
    }

    public User getSampleUser(){
        User user = new User();
        user.setFirstName("Mike");
        user.setLastName("Magic");
        user.setLogin("Mike");
        user.setPassword("fff111");
        user.setEmail("asd@mail.ru");
        user.setUserProfile(getUserProfile());
        return user;
    }

    /*@Autowired
    private UserDao userDao;
    @Autowired
    UserProfileDao userProfileDao;

    @Before
    public void saveUserProfile() {
        userProfileDao.save(getUserProfile());
    }


  	@Test
    public void saveUser(){
        userDao.save(getUser());
        Assert.assertEquals(userDao.findAll().size(), 1);
    }

    private User getUser() {
        User user = new User();
        user.setId(1);
        user.setLogin("login");
        user.setPassword("213");
        user.setFirstName("ddd");
        user.setLastName("ccc");
        user.setEmail("as@as");
        user.setUserProfile(getUserProfile());
        return user;
    }
*/
    public UserProfile getUserProfile() {
        UserProfile userProfile = new UserProfile();
        //userProfile.setId(2);
        userProfile.setRole("Developer");
        return userProfile;
    }
}
