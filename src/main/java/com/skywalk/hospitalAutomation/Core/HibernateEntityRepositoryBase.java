/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skywalk.hospitalAutomation.Core;

import java.lang.ProcessBuilder.Redirect.Type;
import java.util.List;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

public class HibernateEntityRepositoryBase<T> implements IEntityRepository<T> {

    private EntityManager entityManager;
    private Class<T> typeClass;
    public HibernateEntityRepositoryBase(EntityManager entityManager,Class<T> typeClass) {
        this.entityManager = entityManager;
        this.typeClass = typeClass;
    }

    @Override
    @Transactional
    public List<T> getAll() {
        Session session = entityManager.unwrap(Session.class); 
        List<T> entites = (List<T>) session.createQuery("from " + typeClass.getName() ,typeClass).getResultList();
        return entites;
    }

    @Override
    public void add(T entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(T entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(T entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
