/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.Business;

import com.hospitalautomation.Entities.Expertise;
import java.util.List;

/**
 *
 * @author Monster
 */
public interface IExpertiseService {
   List<Expertise> getList(); 
   Expertise getById(int id);
   void add(Expertise expertise);
   void update(Expertise expertise);
   void delete(int id);
}
