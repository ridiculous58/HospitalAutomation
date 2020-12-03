/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.DataAccess;

import com.hospitalautomation.Entities.PatientAppointment;
import com.hospitalautomation.Infrastructure.HibernateEntityRepositoryBase;

/**
 *
 * @author Monster
 */
public class HibernatePatientAppointmentDal extends HibernateEntityRepositoryBase<PatientAppointment> implements IPatientAppointmentDal{

    public HibernatePatientAppointmentDal() {
        super(PatientAppointment.class);
    }
    
}
