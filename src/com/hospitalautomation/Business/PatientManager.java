/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.Business;

import com.hospitalautomation.DataAccess.IPatientDal;
import com.hospitalautomation.Entities.Patient;
import java.util.List;

/**
 *
 * @author Monster
 */
public class PatientManager implements IPatientService{

    private IPatientDal patientDal;

    public PatientManager(IPatientDal patientDal) {
        this.patientDal = patientDal;
    }
    
    
    @Override
    public List<Patient> getList() {
        return patientDal.getList();
    }

    @Override
    public Patient getById(int id) {
        return patientDal.get(id);
    }

    @Override
    public void add(Patient patient) {
        patientDal.add(patient);
    }

    @Override
    public void update(Patient patient) {
        patientDal.update(patient);
    }

    @Override
    public void delete(int id) {
        Patient current_patient = patientDal.get(id);
        patientDal.delete(current_patient);
    }
    
}
