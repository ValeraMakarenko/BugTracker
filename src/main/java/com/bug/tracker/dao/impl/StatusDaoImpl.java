package com.bug.tracker.dao.impl;

import com.bug.tracker.dao.AbstractDao;
import com.bug.tracker.dao.StatusDao;
import com.bug.tracker.model.Status;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("statusDao")
public class StatusDaoImpl extends AbstractDao<Integer, Status> implements StatusDao {

    @Autowired
    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    @Override
    public List<Status> findAll() {
        Session session = sessionFactory.getCurrentSession();

        Query query = session.createQuery("FROM Status");

        List list = query.list();
        System.out.println(list);

        return query.list();

        /*Criteria crit = createEntityCriteria();
        crit.addOrder(Order.asc("role"));
        return (List<UserProfile>)crit.list();*/
    }

    @Override
    public Status findById(int id) {
        return getByKey(id);
    }

    @Override
    public Status findByType(String type) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("type", type));
        return (Status) crit.uniqueResult();
    }
}
