package com.bug.tracker.dao.impl;

import com.bug.tracker.dao.AbstractDao;
import com.bug.tracker.dao.BugReportDao;
import com.bug.tracker.model.BugReport;
import com.bug.tracker.model.Project;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("BugReportDao")
public class BugReportDaoImpl extends AbstractDao<Integer, BugReport> implements BugReportDao {

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

    @Override
    public List<BugReport> findBugReportsForProject(Project project) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("project", project));
        return (List<BugReport>) criteria.list();
    }

}
