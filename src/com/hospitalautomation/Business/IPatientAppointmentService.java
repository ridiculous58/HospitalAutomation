/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.Business;

import com.hospitalautomation.Entities.PatientAppointment;
import java.util.List;

/**
 *
 * @author Monster
 */
public interface IPatientAppointmentService {
   List<PatientAppointment> getList(); 
   PatientAppointment getById(int id);
   void add(PatientAppointment patientAppointment);
   void update(PatientAppointment patientAppointment);
   void delete(int id);

    public List<PatientAppointment> getByPatientIdList(int patientId);

    public List<PatientAppointment> getByDoctorIdList(int doctorId);
}
