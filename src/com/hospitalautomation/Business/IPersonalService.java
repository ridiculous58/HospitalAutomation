/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.Business;

import com.hospitalautomation.Entities.Personal;
import java.util.List;

/**
 *
 * @author Monster
 */
public interface IPersonalService {
   List<Personal> getList(); 
   Personal getById(int id);
   void add(Personal position);
   void update(Personal position);
   void delete(int id);

   public Personal getByUserName(String userName);

   public Personal IsAuthenticated(String userName, String password);
   
}
