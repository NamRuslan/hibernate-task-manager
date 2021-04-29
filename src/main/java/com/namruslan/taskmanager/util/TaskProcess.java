package com.namruslan.taskmanager.util;

import com.namruslan.taskmanager.entity.TaskHibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class TaskProcess {

    private SessionFactory sessionFactory;

    public TaskProcess() {
        sessionFactory = HibernateUtil.getSessionFactory();
    }

    public List<TaskHibernate> getAll() {
        Session session = sessionFactory.openSession();
        session.get(TaskHibernate.class, 0);

        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
        CriteriaQuery<TaskHibernate> criteriaQuery = criteriaBuilder.createQuery(TaskHibernate.class);

        Root<TaskHibernate> root = criteriaQuery.from(TaskHibernate.class);
        criteriaQuery.select(root);

        Query query = session.createQuery(criteriaQuery);

        List<TaskHibernate> list = query.getResultList();

        session.close();

        return list;
    }

}
