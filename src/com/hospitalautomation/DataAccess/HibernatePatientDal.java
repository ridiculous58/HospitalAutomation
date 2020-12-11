/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.DataAccess;

import com.hospitalautomation.Entities.Doctor;
import com.hospitalautomation.Entities.Patient;
import com.hospitalautomation.Infrastructure.HibernateEntityRepositoryBase;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

/**
 *
 * @author Monster
 */
public class HibernatePatientDal extends HibernateEntityRepositoryBase<Patient> implements IPatientDal{

    private SessionFactory sessionFactory;
    private Session session;
    public HibernatePatientDal() {
        super(Patient.class);
        this.sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Patient.class)
                .buildSessionFactory();
    }

    @Override
    public Patient getByUserNameAndPassword(String userName, String password) {
        Patient patient = null;

        session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            String sqlQuery = "From Patient P WHERE P.userName = :patient_userName And P.password = :patient_password ";
            Query query = session.createQuery(sqlQuery);
            query.setParameter("patient_userName",userName);
            query.setParameter("patient_password",password);
            if (query.list().isEmpty()) {
            } else {
                patient = (Patient) query.list().get(0);
            }
            session.getTransaction().commit();
        }
        finally{
            session.close();
        }
        if (patient != null) {
            return patient;
        }
        return null;
    }

    @Override
    public Patient getByUserName(String userName) {
        Patient patient = null;

        session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            String sqlQuery = "From Patient P WHERE P.userName = :patient_userName";
            Query query = session.createQuery(sqlQuery);
            query.setParameter("patient_userName",userName);
            if (query.list().isEmpty()) {
            } else {
                patient = (Patient) query.list().get(0);
            }
            session.getTransaction().commit();
        }
        finally{
            session.close();
        }
        if (patient != null) {
            return patient;
        }
        return null;
    }
    
}
