/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.DataAccess;

import com.hospitalautomation.Entities.Doctor;
import com.hospitalautomation.Entities.Expertise;
import com.hospitalautomation.Infrastructure.HibernateEntityRepositoryBase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author Monster
 */
public class HibernateDoctorDal extends HibernateEntityRepositoryBase<Doctor> implements IDoctorDal ,IDoctorLoginService{
    private SessionFactory sessionFactory;
    private Session session;
    
    public HibernateDoctorDal() {
        super(Doctor.class);
        this.sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Doctor.class)
                .buildSessionFactory();
    }

    @Override
    public Doctor IsAuthenticated(String userName, String password) {
        Doctor doctor = null;

        session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            String sqlQuery = "From Doctor D WHERE D.userName = :doctor_userName And D.password = :doctor_password ";
            Query query = session.createQuery(sqlQuery);
            query.setParameter("doctor_userName",userName);
            query.setParameter("doctor_password",password);
            if (query.list().isEmpty()) {
            } else {
                doctor = (Doctor) query.list().get(0);
            }
            session.getTransaction().commit();
        }
        finally{
            session.close();
        }
        if (doctor != null) {
            return doctor;
        }
        return null;
    }

    @Override
    public Doctor getByUserName(String userName) {
        Doctor doctor = null;
        session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            String sqlQuery = "From Doctor D WHERE D.userName = :doctor_userName";
            Query query = session.createQuery(sqlQuery);
            query.setParameter("doctor_userName",userName);
            if (query.list().isEmpty()) {
            } else {
                doctor = (Doctor) query.list().get(0);
            }
            session.getTransaction().commit();
        }
        finally{
            session.close();
        }
        if (doctor != null) {
            return doctor;
        }
        return null;
    }


}
