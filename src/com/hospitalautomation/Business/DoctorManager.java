/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.Business;

import com.hospitalautomation.DataAccess.*;
import com.hospitalautomation.Entities.Doctor;
import java.util.List;

/**
 *
 * @author Monster
 */
public class DoctorManager implements IDoctorService{
    private IDoctorDal doctorDal;
    public DoctorManager(IDoctorDal doctorDal) {
        this.doctorDal = doctorDal;
    }

    @Override
    public List<Doctor> getList() {
        return doctorDal.getList();
    }

    @Override
    public void add(Doctor doctor) {
        doctorDal.add(doctor);
    }

    @Override
    public void update(Doctor doctor) {
        doctorDal.update(doctor);
    }

    @Override
    public void delete(int id) {
        Doctor current_doctor = doctorDal.get(id);
        doctorDal.delete(current_doctor);
    }
}
