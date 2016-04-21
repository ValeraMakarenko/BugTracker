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

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = HibernateTestConfiguration.class)
@Transactional
public class UserDaoImplTest{

    @Autowired
    UserDao userDao;

  	@Test
    public void saveUser(){
        userDao.save(getSampleUser());
        Assert.assertEquals(userDao.findAll().size(), 1);
    }

    public User getSampleUser(){
        User user = new User();
        user.setFirstName("Mike");
        user.setLastName("Magic");
        user.setLogin("Mike");
        user.setPassword("fff111");
        user.setEmail("asd@mail.ru");
        user.setUserProfiles(getSampleRole());
        return user;
    }

    public Set<UserProfile> getSampleRole(){
        Set<UserProfile> role = new HashSet<>();
        UserProfile userProfile = new UserProfile();
        userProfile.setId(2);
        userProfile.setRole("Developer");
        role.add(userProfile);
        return role;
    }

}
