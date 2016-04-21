package com.bug.tracker.dao.impl;

import com.bug.tracker.dao.AbstractDao;
import com.bug.tracker.dao.PriorityDao;
import com.bug.tracker.model.Priority;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("priorityDao")
public class PriorityDaoImpl extends AbstractDao<Integer, Priority> implements PriorityDao {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Priority> findAll() {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("FROM Priority");

        List list = query.list();
        System.out.println(list);

        return query.list();

        /*Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("role"));
        return (List<UserProfile>)crit.list();*/
    }

    @Override
    public Priority findById(int id) {
        return getByKey(id);
    }

    @Override
    public Priority findByType(String type) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("type", type));
        return (Priority) crit.uniqueResult();
    }
}