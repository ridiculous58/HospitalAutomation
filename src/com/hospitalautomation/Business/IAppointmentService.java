/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.Business;

import com.hospitalautomation.Entities.Appointment;
import java.util.List;

/**
 *
 * @author Monster
 */
public interface IAppointmentService {
   List<Appointment> getList(); 
   Appointment getById(int id);
   void add(Appointment appointment);
   void update(Appointment appointment);
   void delete(int id);
}