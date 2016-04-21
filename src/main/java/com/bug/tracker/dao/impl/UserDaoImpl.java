package com.bug.tracker.dao.impl;

import com.bug.tracker.dao.AbstractDao;
import com.bug.tracker.dao.UserDao;
import com.bug.tracker.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(User user) {
        persist(user);
    }

    public User findById(int id) {
        return getByKey(id);
    }

    public User findByLogin(String login) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("login", login));
        return (User) crit.uniqueResult();
    }

    @Override
    public List<User> findAll() {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("FROM User");

        List list = query.list();
        System.out.println(list);

        return query.list();
    }

}
