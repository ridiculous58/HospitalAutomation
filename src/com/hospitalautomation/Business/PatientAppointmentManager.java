/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.Business;

import com.hospitalautomation.DataAccess.IPatientAppointmentDal;
import com.hospitalautomation.Entities.PatientAppointment;
import java.util.List;

/**
 *
 * @author Monster
 */
public class PatientAppointmentManager  implements IPatientAppointmentService{

    private IPatientAppointmentDal patientAppointmentDal;

    public PatientAppointmentManager(IPatientAppointmentDal patientAppointmentDal) {
        this.patientAppointmentDal = patientAppointmentDal;
    }
    
    @Override
    public List<PatientAppointment> getList() {
        return  patientAppointmentDal.getList();
    }

    @Override
    public PatientAppointment getById(int id) {
        return patientAppointmentDal.get(id);
    }

    @Override
    public void add(PatientAppointment patientAppointment) {
        patientAppointmentDal.add(patientAppointment);
    }

    @Override
    public void update(PatientAppointment patientAppointment) {
        patientAppointmentDal.update(patientAppointment);
    }

    @Override
    public void delete(int id) {
        PatientAppointment current_patient = patientAppointmentDal.get(id);
        patientAppointmentDal.delete(current_patient);
    }
    
}
