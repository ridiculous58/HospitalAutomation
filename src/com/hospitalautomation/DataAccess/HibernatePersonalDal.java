/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.DataAccess;

import com.hospitalautomation.Entities.Personal;
import com.hospitalautomation.Infrastructure.HibernateEntityRepositoryBase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author Monster
 */
public class HibernatePersonalDal extends HibernateEntityRepositoryBase<Personal> implements IPersonalDal{
    private SessionFactory sessionFactory;
    private Session session;
    public HibernatePersonalDal() {
        super(Personal.class);
         this.sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Personal.class)
                .buildSessionFactory();
    }
    @Override
    public Personal IsAuthenticated(String userName, String password) {
         Personal personal = null;

        session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            String sqlQuery = "From Personal P WHERE P.userName = :personal_userName And P.password = :personal_password";
            Query query = session.createQuery(sqlQuery);
            query.setParameter("personal_userName",userName);
            query.setParameter("personal_password",password);
            if (query.list().isEmpty()) {
            } else {
                personal = (Personal) query.list().get(0);
            }
            session.getTransaction().commit();
        }
        finally{
            session.close();
        }
        if (personal != null) {
            return personal;
        }
        return null;
    }
    @Override
    public Personal getByUserName(String userName) {
        Personal personal = null;
        session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            String sqlQuery = "From Personal P WHERE P.userName = :personal_userName";
            Query query = session.createQuery(sqlQuery);
            query.setParameter("personal_userName",userName);
            if (query.list().isEmpty()) {
            } else {
                personal = (Personal) query.list().get(0);
            }
            session.getTransaction().commit();
        }
        finally{
            session.close();
        }
        if (personal != null) {
            return personal;
        }
        return null;
    }


    
}
