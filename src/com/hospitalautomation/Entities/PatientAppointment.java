/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.Entities;

import com.hospitalautomation.Infrastructure.IEntity;
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
    @Column(name = "AppointmentId")
    private int appointmentId;

    public PatientAppointment() {
    }

    public PatientAppointment(int id, int patientId, int appointmentId) {
        this.id = id;
        this.patientId = patientId;
        this.appointmentId = appointmentId;
    }

    public PatientAppointment(int patientId, int appointmentId) {
        this.patientId = patientId;
        this.appointmentId = appointmentId;
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

    public int getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(int appointmentId) {
        this.appointmentId = appointmentId;
    }
    
    
}
