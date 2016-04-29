package com.bug.tracker.dao.impl;

import com.bug.tracker.dao.AbstractDao;
import com.bug.tracker.dao.StatusDao;
import com.bug.tracker.model.Status;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("statusDao")
public class StatusDaoImpl extends AbstractDao<Integer, Status> implements StatusDao {

    @Override
    public List<Status> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("id"));
        return (List<Status>)criteria.list();
    }

    @Override
    public Status findById(int id) {
        return getByKey(id);
    }

    @Override
    public void save(Status status) {
        persist(status);
    }

    @Override
    public Status findByType(String type) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("type", type));
        return (Status) crit.uniqueResult();
    }
}
