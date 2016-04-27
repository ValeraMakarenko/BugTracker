package com.bug.tracker.dao.impl;

import com.bug.tracker.dao.AbstractDao;
import com.bug.tracker.dao.UserProfileDao;
import com.bug.tracker.model.UserProfile;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer, UserProfile> implements UserProfileDao {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    @Transactional
    public List<UserProfile> findAll(){
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("FROM UserProfile");

        return  query.list();

        /*Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("role"));
        return (List<UserProfile>)crit.list();*/
    }

    @Override
    public UserProfile findById(int id) {
        return getByKey(id);
    }

    @Override
    public UserProfile findByRole(String role) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("role", role));
        return (UserProfile) crit.uniqueResult();
    }
}
