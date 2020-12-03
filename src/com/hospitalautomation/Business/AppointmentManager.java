/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.Business;

import com.hospitalautomation.DataAccess.IAppointmentDal;
import com.hospitalautomation.Entities.Appointment;
import java.util.List;

/**
 *
 * @author Monster
 */
public class AppointmentManager implements  IAppointmentService{

    private IAppointmentDal appointmentDal;

    public AppointmentManager(IAppointmentDal appointmentDal) {
        this.appointmentDal = appointmentDal;
    }
    
    @Override
    public List<Appointment> getList() {
        return appointmentDal.getList();
    }

    @Override
    public Appointment getById(int id) {
        return appointmentDal.get(id);
    }

    @Override
    public void add(Appointment appointment) {
        appointmentDal.add(appointment);
    }

    @Override
    public void update(Appointment appointment) {
        appointmentDal.update(appointment);
    }

    @Override
    public void delete(int id) {
        Appointment current_appointment = appointmentDal.get(id);
        appointmentDal.delete(current_appointment);
    }
    
}
