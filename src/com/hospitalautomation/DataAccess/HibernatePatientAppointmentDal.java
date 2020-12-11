/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.DataAccess;

import com.hospitalautomation.Entities.PatientAppointment;
import com.hospitalautomation.Infrastructure.HibernateEntityRepositoryBase;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


/**
 *
 * @author Monster
 */
public class HibernatePatientAppointmentDal extends HibernateEntityRepositoryBase<PatientAppointment> implements IPatientAppointmentDal{
    private SessionFactory sessionFactory;
    private Session session;
    public HibernatePatientAppointmentDal() {
        super(PatientAppointment.class);
         this.sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(PatientAppointment.class)
                .buildSessionFactory();
    }

    @Override
    public List<PatientAppointment> getByPatientIdList(int patientId) {
        List<PatientAppointment> getList = null;
        session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            String sqlQuery = "From PatientAppointment P where P.patientId = :patientAppointment_patientId ";
            Query query = session.createQuery(sqlQuery);
            query.setParameter("patientAppointment_patientId",patientId);
            getList = query.list();
            session.getTransaction().commit();
        }
        finally{
            session.close();
        }
        return getList;
    }

    @Override
    public List<PatientAppointment> getByDoctorIdList(int doctorId) {
        List<PatientAppointment> getList = null;
        session = sessionFactory.getCurrentSession();
        try{
            session.beginTransaction();
            String sqlQuery = "From PatientAppointment P where P.doctorId = :patientAppointment_doctorId";
            Query query = session.createQuery(sqlQuery);
            query.setParameter("patientAppointment_doctorId",doctorId);
            getList = query.list();
            session.getTransaction().commit();
        }
        finally{
            session.close();
        }
        return getList;
    }
    
}
