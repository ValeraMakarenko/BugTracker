package com.bug.tracker.dao.impl;

import com.bug.tracker.dao.AbstractDao;
import com.bug.tracker.dao.TypeProjectDao;
import com.bug.tracker.model.TypeProject;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("typeProjectDao")
public class TypeProjectDaoImpl extends AbstractDao<Integer, TypeProject> implements TypeProjectDao {
    @Override
    public List<TypeProject> findAll() {
        Criteria criteria = createEntityCriteria();
        criteria.addOrder(Order.asc("id"));
        return (List<TypeProject>)criteria.list();
    }

    @Override
    public TypeProject findByType(String type) {
        Criteria crit = createEntityCriteria();
        crit.add(Restrictions.eq("type", type));
        return (TypeProject) crit.uniqueResult();
    }

    @Override
    public TypeProject findById(int id) {
        return getByKey(id);
    }

    @Override
    public void save(TypeProject typeProject) {
        persist(typeProject);
    }

}
