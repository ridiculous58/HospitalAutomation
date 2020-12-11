/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.DataAccess;

import com.hospitalautomation.Entities.PatientAppointment;
import com.hospitalautomation.Infrastructure.IEntityRepository;
import java.util.List;

/**
 *
 * @author Monster
 */
public interface IPatientAppointmentDal extends IEntityRepository<PatientAppointment>{

    public List<PatientAppointment> getByPatientIdList(int patientId);

    public List<PatientAppointment> getByDoctorIdList(int doctorId);

    
}
