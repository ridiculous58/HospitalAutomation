/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.DataAccess;

import com.hospitalautomation.Entities.City;
import com.hospitalautomation.Entities.Doctor;
import com.hospitalautomation.Infrastructure.HibernateEntityRepositoryBase;

/**
 *
 * @author Monster
 */
public class HibernateDoctorDal extends HibernateEntityRepositoryBase<Doctor> implements IDoctorDal {
    public HibernateDoctorDal() {
        super(Doctor.class);
    }
}
