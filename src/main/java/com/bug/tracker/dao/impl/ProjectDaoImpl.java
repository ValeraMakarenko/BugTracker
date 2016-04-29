package com.bug.tracker.dao.impl;

import com.bug.tracker.dao.AbstractDao;
import com.bug.tracker.dao.ProjectDao;
import com.bug.tracker.model.Project;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("ProjectDao")
public class ProjectDaoImpl extends AbstractDao<Integer, Project> implements ProjectDao {

    @Override
    public void save(Project project) {
        persist(project);
    }

    @Override
    public Project findById(int id) {
        return getByKey(id);
    }

    @Override
    public List<Project> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("id"));
        return (List<Project>)criteria.list();
    }

    @Override
    public void deleteProjectById(int id) {
        Criteria criteria = createEntityCriteria();
        criteria.add(Restrictions.eq("id", id));
        Project project = (Project)criteria.uniqueResult();
        delete(project);
    }
}

