/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.Entities;

import com.hospitalautomation.Infrastructure.IEntity;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Monster
 */
@Entity
@Table(name = "PatientAppointments")
public class PatientAppointment implements IEntity{
    @Id
    @Column(name = "Id")
    private int id;
    @Column(name = "PatientId")
    private int patientId;
    @Column(name = "DoctorId")
    private int doctorId;
    @Column(name = "AppointmentDatetime")
    private LocalDateTime appointmentDateTime;

    public PatientAppointment() {
    }

    public PatientAppointment(int patientId,  int doctorId, LocalDateTime appointmentDatetime) {
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDateTime = appointmentDatetime;
    }

    public PatientAppointment(int id, int patientId, int doctorId, LocalDateTime appointmentDatetime) {
        this.id = id;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.appointmentDateTime = appointmentDatetime;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }

    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }



    
    
}
