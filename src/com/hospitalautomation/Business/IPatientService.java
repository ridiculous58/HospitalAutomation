/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.Business;

import com.hospitalautomation.Entities.Patient;
import java.util.List;

/**
 *
 * @author Monster
 */
public interface IPatientService {
   List<Patient> getList(); 
   Patient getById(int id);
   void add(Patient patient);
   void update(Patient patient);
   void delete(int id);
}
