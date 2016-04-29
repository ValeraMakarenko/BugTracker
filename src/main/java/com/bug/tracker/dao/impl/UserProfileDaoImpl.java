package com.bug.tracker.dao.impl;

import com.bug.tracker.dao.AbstractDao;
import com.bug.tracker.dao.UserProfileDao;
import com.bug.tracker.model.UserProfile;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userProfileDao")
public class UserProfileDaoImpl extends AbstractDao<Integer, UserProfile> implements UserProfileDao {

    @Override
    public List<UserProfile> findAll(){
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("id"));
        return (List<UserProfile>)criteria.list();
    }

    @Override
    public UserProfile findById(int id) {
        return getByKey(id);
    }

    @Override
    public void save(UserProfile userProfile) {
        persist(userProfile);
    }

    @Override
    public UserProfile findByRole(String role) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("role", role));
        return (UserProfile) crit.uniqueResult();
    }
}
