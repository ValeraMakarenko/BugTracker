package com.bug.tracker.dao.impl;

import com.bug.tracker.dao.AbstractDao;
import com.bug.tracker.dao.BugReportDao;
import com.bug.tracker.model.BugReport;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("BugReportDao")
public class BugReportDaoImpl extends AbstractDao<Integer, BugReport> implements BugReportDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void save(BugReport bugReport) {
        persist(bugReport);
    }

    public BugReport findById(int id) {
        return getByKey(id);
    }

    @Override
    public List<BugReport> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("id"));
        return (List<BugReport>)criteria.list();

    }

    @Override
    public void deleteBugReportById(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        BugReport bugReport = (BugReport)criteria.uniqueResult();
        delete(bugReport);
    }

}
