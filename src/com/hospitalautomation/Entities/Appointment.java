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


@Entity
@Table(name = "Appointments")
public class Appointment implements IEntity{
    @Id
    @Column(name = "Id")
    private int id;
    @Column(name = "DoctorId")
    private int doctorId;
    @Column(name = "AppointmentDateTime")
    private LocalDateTime appointmentDateTime;

    public Appointment() {
    }
    
    public Appointment(int doctorId, LocalDateTime appointmentDateTime) {
        this.doctorId = doctorId;
        this.appointmentDateTime = appointmentDateTime;
    }

    public Appointment(int id, int doctorId, LocalDateTime appointmentDateTime) {
        this.id = id;
        this.doctorId = doctorId;
        this.appointmentDateTime = appointmentDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
