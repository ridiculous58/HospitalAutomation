/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.Business;

import com.hospitalautomation.Entities.Doctor;
import java.util.List;

/**
 *
 * @author Monster
 */
public interface IDoctorService {
   List<Doctor> getList(); 
   void add(Doctor doctor);
   void update(Doctor doctor);
   void delete(int id);
}
