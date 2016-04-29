package com.bug.tracker.dao.impl;

import com.bug.tracker.dao.AbstractDao;
import com.bug.tracker.dao.PriorityDao;
import com.bug.tracker.model.Priority;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("priorityDao")
public class PriorityDaoImpl extends AbstractDao<Integer, Priority> implements PriorityDao {

    @Override
    public List<Priority> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("id"));
        return (List<Priority>)criteria.list();
    }

    @Override
    public Priority findById(int id) {
        return getByKey(id);
    }

    @Override
    public void save(Priority priority) {
        persist(priority);
    }

    @Override
    public Priority findByType(String type) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("type", type));
        return (Priority) crit.uniqueResult();
    }
}