/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.Infrastructure;

import java.util.List;
import java.sql.SQLException;
import java.sql.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.springframework.beans.factory.annotation.Value;

public class HibernateEntityRepositoryBase<T extends IEntity>  implements IEntityRepository<T> {

    /*@Value("${database.connectionString}")
    private String connectionString;*/
    
    private SessionFactory sessionFactory;
    private Session session;
    private Class<T> currentClass;
    public HibernateEntityRepositoryBase(Class<T> currentClass) {
        this.sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(currentClass)
                .buildSessionFactory();
        this.currentClass = currentClass;

        
    }
    @Override
    public List<T> getList() {
        List<T> getList = null;
        session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            getList = session.createQuery("from " + currentClass.getSimpleName()).getResultList();
            session.getTransaction().commit();
        }
        finally{
            session.close();
        }
        return getList;
    }

    @Override
    public T get(int id) {
        session = sessionFactory.getCurrentSession();
        T entity = null;
        try{
            session.beginTransaction();
            entity = session.get(currentClass,id);
            session.getTransaction().commit();
        }
        finally{
            session.close();
        }
        return entity;
    }

    @Override
    public void add(T entity) {
        session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        }
        finally{
            session.close();
        }
    }

    @Override
    public void update(T entity) {
          session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            session.saveOrUpdate(entity);
            session.getTransaction().commit();
        }
        finally{
            session.close();
        }
    }

    @Override
    public void delete(T entity) {
         session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            session.delete(entity);
            session.getTransaction().commit();
        }
        finally{
            session.close();
        }
    }
    
}
